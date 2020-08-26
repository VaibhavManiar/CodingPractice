package com.practice;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExceptionHandlers {

    private final Map<ExceptionHandlerKey<?>, ExceptionHandler<?>> exceptionHandlerMap;

    private ExceptionHandlers(Map<ExceptionHandlerKey<?>, ExceptionHandler<?>> exceptionHandlerMap) {
        this.exceptionHandlerMap = exceptionHandlerMap;
    }

    public static class Builder {
        private final Map<ExceptionHandlerKey<?>, ExceptionHandler<?>> exceptionHandlerMap;

        public Builder() {
            this.exceptionHandlerMap = new ConcurrentHashMap<>();
        }

        public Builder addHandler(ExceptionHandler<?> handler) {
            this.exceptionHandlerMap.put(ExceptionHandlerKey.generateKey(handler.getClazz()), handler);
            return this;
        }

        public ExceptionHandlers build() {
            return new ExceptionHandlers(this.exceptionHandlerMap);
        }
    }

    public interface ExceptionHandler<R> {
        Class<?> getClazz();

        R handleException(Exception e);
    }

    public static abstract class AbstractExceptionHandler<R> implements ExceptionHandler<R> {
        private final Class<?> clazz;

        private AbstractExceptionHandler(Exception e) {
            this.clazz = e.getClass();
        }

        @Override
        public Class<?> getClazz() {
            return this.clazz;
        }
    }

    private static boolean isOfExceptionType(Class<?> clazz) {
        try {
            return clazz.newInstance() instanceof Exception;
        } catch (InstantiationException | IllegalAccessException e) {
            // TODO: logger.error("Only exception instance is allowed as exception handler.");
            return false;
        }
    }

    public ExceptionHandler<?> getExceptionHandler(Class<?> clazz) {
        return this.exceptionHandlerMap.get(ExceptionHandlerKey.generateKey(clazz));
    }

    public static class ExceptionHandlerKey<T> {
        private final Class<T> clazz;

        private ExceptionHandlerKey(Class<T> clazz) {
            this.clazz = clazz;
        }

        public Class<T> getClazz() {
            return clazz;
        }

        public static ExceptionHandlerKey<?> generateKey(Class<?> clazz) {
            return new ExceptionHandlerKey<>(clazz);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ExceptionHandlerKey)) return false;
            ExceptionHandlerKey<?> that = (ExceptionHandlerKey<?>) o;
            return this.clazz.getName().equals(that.clazz.getName());
        }

        @Override
        public int hashCode() {
            return this.clazz.getName().hashCode();
        }
    }

    public static class CustomException extends Exception {

        Type t;
        CustomException(Type type) {
            this.t = type;
        }

        public enum Type {
            CommandException, SystemException
        }
    }

    public static void main(String[] args) {
        Exception e = new Exception();
        System.out.println(new Builder().addHandler(new AbstractExceptionHandler<String>(new CustomException(CustomException.Type.CommandException)) {
            @Override
            public String handleException(Exception e) {
                CustomException ce = (CustomException) e;
                return ce.getMessage();
            }
        }).build().getExceptionHandler(e.getClass()).handleException(e));
    }
}
