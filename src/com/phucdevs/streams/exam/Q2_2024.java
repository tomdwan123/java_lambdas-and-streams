package com.phucdevs.streams.exam;

import java.util.stream.DoubleStream;

public class Q2_2024 {

    public static void main(String[] args) {

        /*
            There are two parts:
            a. Generate a DoubleStream using the of() method consisting of the numbers 0, 2 and 4. Note
               that this stream is a stream of primitives and not a stream of types. Filter in odd numbers only
               and sum the remaining stream. You should get 0.
            b. Using 1.0 and 3.0, generate a stream of Double’s. Map them to primitive double’s. Filter in
               even numbers only and calculate the average. Output the result without running the risk of generating an exception.
        */

        // sum
        DoubleStream stream1 = DoubleStream.of(0, 2, 4);
        double sum = stream1.filter(d -> d % 2 != 0).sum();
        System.out.println("sum = " + sum);

        // avg
        DoubleStream stream2 = DoubleStream.of(1.0, 3.0);
        double avg = stream2.filter(d -> d % 2 == 0).average().orElse(0.0);
        System.out.println("avg = " + avg);
    }
}
