package com.phucdevs.streams.terminal_operations;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOperationsMappingPrimitiveStreams {

    public static void main(String[] args) {

        example1();
    }

    private static void example1() {

        // IntStream to Stream<T>
        Stream<String> streamAges = IntStream.of(1, 2, 3)
                .mapToObj(n -> "Number:" + n);

        // forEach is a terminal operation which closes the stream
        // forEach(Consumer) - Consumer is a functional interface:
        //    void accept(T t)
        streamAges.forEach(System.out::println); // Number:1, Number:2, Number:3

        // IntStream to DoubleStream
        DoubleStream db1Stream = IntStream.of(1, 2, 3)
                .mapToDouble(n -> (double) n);
        db1Stream.forEach(System.out::println); // 1.0, 2.0, 3.0

        // IntStream to IntStream
        IntStream.of(1, 2, 3)
                .map(n -> n * 2)
                .forEach(System.out::println); // 2, 4, 6
    }
}
