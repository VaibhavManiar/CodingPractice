package com.practice.tekion;

import java.time.LocalDateTime;
import java.util.List;

public class Q2 {

    public static class Person {
        int id;
        String name;
        String mobileNumber;
    }

    public static class Product {
        int id;
        String name;
        double amount;
        Currency currency;

        public enum Currency {

        }
    }

    public static class OrderedProduct extends Product {
        int quantity;
    }

    public static class Order {
        String number;
        List<OrderedProduct> products;
        Customer customer;
        LocalDateTime orderDateTime;
        Status status;

        public enum Status {
            InTransit, Packed, Delivered
        }
    }

    public static class Customer extends Person {
        Location address;
    }

    public static class DeliverPerson extends Person {

    }

    public static class Track {
        int id;
        Order order;
        List<Product> product;
        Location fromLocation;
        Location toLocation;
        LocalDateTime startDateTime;
        LocalDateTime estimatedDateTime;
        LocalDateTime actualDeliveryDateTime;
        DeliverPerson deliverPerson;
    }

    public static class Location {
        Coordinate coordinate;
        String state;
        String city;
        String pincode;
    }

    public static class Coordinate {
        int x;
        int y;
    }

    public static class Lable {
        Order order;
        Customer customer;

    }
}
