package com.practice.dailycodingpractice;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * This problem was asked by Twitter.
 *
 * You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:
 *
 * record(order_id): adds the order_id to the log
 * get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
 * You should be as efficient with time and space as possible.
 */
public class Q16_LRU {

    private final int capacity;
    private int size;
    private final CustomList<Order> orderList;
    private final Map<Integer, LinkedCustomList.Node<Order>> recentOrdersMap;
    private final ReentrantReadWriteLock lock;

    public Q16_LRU (int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.orderList = new LinkedCustomList<>(this.capacity);
        this.recentOrdersMap = new HashMap<>(this.capacity);
        this.lock = new ReentrantReadWriteLock();
    }

    public void add(Order order) {
        if(order == null) {
            throw new RuntimeException("input order must not be null.");
        }
        if(this.recentOrdersMap.containsKey(order.orderId)) {
            throw new RuntimeException("Order with order id already present.");
        }
        this.lock.writeLock().lock();
        if(this.orderList.getSize() == this.capacity) {
            this.orderList.removeFromStart();
            this.size--;
        }
        this.size++;
        LinkedCustomList.Node<Order> last = ((LinkedCustomList<Order>)this.orderList.add(order)).getLast();
        this.recentOrdersMap.put(order.orderId, last);
        this.lock.writeLock().unlock();
    }

    public Optional<Order> getByOrderId(int orderId) {
        return Optional.ofNullable(this.recentOrdersMap.get(orderId).getT());
    }

    public Order getByOrderIndex(int index) {
        if(index >= this.size) {
            throw new IndexOutOfBoundsException("Index : " + index);
        }
        return this.orderList.get(index);
    }

    public void remove(Order order) {
        if(order == null) {
            throw new RuntimeException("input order must not be null.");
        }
        if(this.recentOrdersMap.containsKey(order.orderId)) {
            this.lock.writeLock().lock();
            if(this.recentOrdersMap.containsKey(order.orderId)) {
                LinkedCustomList.Node<Order> node = this.recentOrdersMap.get(order.orderId);
                ((LinkedCustomList<Order>) this.orderList).remove(node);
                this.size--;
            }
            this.lock.writeLock().unlock();
        }
    }

    private static class Order {
        int orderId;
    }

}