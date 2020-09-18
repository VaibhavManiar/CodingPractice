package com.practice.java8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class NioJava8Example {

    public static void sol() throws IOException {
        Files.list(Paths.get("/tmp")).forEach(path -> System.out.println(path.getFileName()));
        Files.lines(Files.list(Paths.get("/")).findFirst().get());
    }

    public static void main(String[] args) throws IOException {
        sol();
    }
}
