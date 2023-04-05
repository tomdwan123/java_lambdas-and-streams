package com.phucdevs.streams.terminal_operations;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TerminalOperationsObjectsStream {

    public static void main(String[] args) {

        example1();
    }

    private static void example1() {

        // Stream<T> to Stream<T>
        Stream.of("ash", "beech", "sycamore")
                .map(tree -> tree.toUpperCase())
                .forEach(System.out::print); // ASHBEECHSYCAMORE

        // Stream<T> to DoubleStream
        DoubleStream doubleStream = Stream.of("ash", "beech", "sycamore")
                .mapToDouble(tree -> tree.length());
        doubleStream.forEach(System.out::print); // 3.0, 5.0, 8.0

        // Stream<T> to IntStream
        IntStream intStream = Stream.of("ash", "beech", "sycamore")
                .mapToInt(tree -> tree.length());
        intStream.forEach(System.out::print); // 3, 5, 8

        // Stream<T> to LongStream
        LongStream longStream = Stream.of("ash", "beech", "sycamore")
                .mapToLong(tree -> tree.length());
        longStream.forEach(System.out::print); // 3, 5, 8
    }
}
