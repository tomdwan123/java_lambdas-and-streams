package com.phucdevs.streams.exam;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Q2_1787 {

    public static void main(String[] args) {

        Stream<List<String>> input = Stream.of(
                Arrays.asList("a", "b"),
                Arrays.asList("d", "c"),
                Arrays.asList("a", "c")
        );

        input.filter(i -> i.contains("c"))
                .peek(System.out::print)
                .flatMap(list -> list.stream())
                .forEach(System.out::print);
    }
}
