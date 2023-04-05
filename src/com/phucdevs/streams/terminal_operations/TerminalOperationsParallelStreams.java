package com.phucdevs.streams.terminal_operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TerminalOperationsParallelStreams {

    public static void main(String[] args) {

        example1();
        example2();
        example3();
        example4();
        example5();
    }

    private static void example1() {

        Stream<String> animals1Stream = List.of("sheep", "pigs", "horses")
                .parallelStream();

        Stream<String> animals2Stream = Stream.of("sheep", "pigs", "horses")
                .parallel();
    }

    private static void example2() {

        // sequential stream works
        // 10 20 30 40 50 60
        //    30 30 40 50 60
        //       60 40 50 60
        //         100 50 60
        //            150 60
        //               210
        int sum = Stream.of(10, 20, 30, 40, 50, 60)
                .mapToInt(n -> n.intValue())
                .sum();
        System.out.println("sum == " + sum); // 210
    }

    private static void example3() {

        // parallel stream works
        // Thread 1             Thread 2
        // 10 20 30             40 50 60
        //    30 30                90 60
        //       60                  150
        //                  210
        int sum = Stream.of(10, 20, 30, 40, 50, 60)
                .parallel()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("sum == " + sum); // 210
    }

    private static void example4() {

        Arrays.asList("a", "b", "c")
                .stream()
                .forEach(System.out::println); // abc
    }

    private static void example5() {

        Arrays.asList("a", "b", "c")
                .stream()
                .parallel().forEach(System.out::println); // bca
    }
}
