package com.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class WordWrap {

    public static List<String> leftIndentation(String data, int maxLineLength) {
        if (Objects.isNull(data)) {
            throw new RuntimeException("Input data must not be a null value");
        }

        if (maxLineLength <= 0) {
            throw new RuntimeException("Max line length must be more then 0");
        }

        List<String> lines = new ArrayList<>();
        String[] words = data.split(" ");
        int currLineLength = 0;
        StringBuilder line = new StringBuilder();
        for (int wordIndex = 0; wordIndex < words.length; wordIndex++) {
            String word = words[wordIndex];
            if (word.length() > maxLineLength) {
                throw new RuntimeException("Not possible to wrap string in left indentation as word length [" + word.length() + "] is more then the maxLineLength " + maxLineLength);
            }

            if (currLineLength + word.length() > maxLineLength) {
                lines.add(line.toString());
                wordIndex--;
                line = new StringBuilder();
                currLineLength = 0;
                continue;
            }
            currLineLength += word.length();
            line.append(word);
            if (currLineLength < maxLineLength) {
                currLineLength++;
                line.append(" ");
            }
        }
        return lines;
        //Developer for--
    }


    public static Response<List<String>> testCase1() {
        try {
            String data = "Hi This is Vaibhav Maniar.";
            List<String> strings = leftIndentation(data, 7);

            return new Response<>(Optional.of(strings), Optional.empty(), Boolean.TRUE);
        } catch (Exception e) {
            return new Response<>(Optional.empty(), Optional.of(new Response.Error(e.getMessage())), Boolean.FALSE);
        }
    }

    public static Response<List<String>> testCase2() {
        try {
            String data = "Developer for        a developer presents word wrap problem.";
            String data1 = "Developer forra \n developer presents word wrap problem.";
            String data2 = "Developerfordeveloper presents word wrap problem.";
            String data3 = "Developer for---- developer presents word wrap problem.";

            List<String> strings = leftIndentation(data, 15);
            System.out.println(strings);

            List<String> strings1 = leftIndentation(data1, 15);
            System.out.println(strings1);

            List<String> strings3 = leftIndentation(data3, 15);
            System.out.println(strings3);

            List<String> strings2 = leftIndentation(data2, 15);
            System.out.println(strings2);

            return new Response<>(Optional.of(strings), Optional.empty(), Boolean.TRUE);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response<>(Optional.empty(), Optional.of(new Response.Error(e.getMessage())), Boolean.FALSE);
        }
    }



    public static void main(String[] args) {
        /*Response<List<String>> response = testCase1();
        System.out.println(response);*/

        Response<List<String>> response1 = testCase2();
        System.out.println(response1);
    }

    public static class Response<T> {
        private final Optional<T> data;
        private final Optional<Error> error;
        private final boolean success;

        public Response(Optional<T> data, Optional<Error> error, boolean success) {
            this.data = data;
            this.error = error;
            this.success = success;
        }

        public Optional<T> getData() {
            return data;
        }

        public Optional<Error> getError() {
            return error;
        }

        public boolean isSuccess() {
            return success;
        }

        public static class Error {
            private final String message;

            public Error(String message) {
                this.message = message;
            }

            public String getMessage() {
                return message;
            }

            @Override
            public String toString() {
                return "Error{" +
                        "message='" + message + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "Response{" +
                    "data=" + data +
                    ", error=" + error +
                    ", success=" + success +
                    '}';
        }
    }
}
