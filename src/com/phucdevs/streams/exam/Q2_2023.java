package com.phucdevs.streams.exam;

import java.util.stream.IntStream;

public class Q2_2023 {

    public static void main(String[] args) {

        // Range [0 .. 5)
        Double d1 = IntStream.range(0, 5)
                .average().getAsDouble();
        System.out.println(d1); // 2.0

        // Range [0 .. 5]
        Double d2 = IntStream.rangeClosed(0, 5)
                .average().getAsDouble();
        System.out.println(d2); // 2.5
    }
}
