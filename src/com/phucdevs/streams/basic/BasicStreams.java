package com.phucdevs.streams.basic;

import java.util.Arrays;
import java.util.List;

public class BasicStreams {

    public static void main(String[] args) {

        /* Output:
            98.4
            100.2
            100.2
            87.9
            102.8
            102.8
            Number of temps > 100 is: 2
         */
        List<Double> temps = Arrays.asList(98.4, 100.2, 87.9, 102.8);
        System.out.println("Number of temps > 100 is: " +
                temps
                    .stream() // create the stream
                    .peek(System.out::println) // show the value
                    .filter(temp -> temp > 100) // filter it
                    .peek(System.out::println)  // show the value
                    .count()); // 2
    }
}
