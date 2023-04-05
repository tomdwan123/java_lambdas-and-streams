package com.phucdevs.streams.streams_laziness;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamLaziness {

    public static void main(String[] args) {
        example1();
        example2();
        example3();
    }

    private static void example1() {

        /* Each element moves along the chain vertically:
                filter: Alex
                forEach: Alex
                filter: David
                forEach: David
                filter: April
                forEach: april
                filter: Edward
                forEach: Edward
         */
        Stream.of("Alex", "David", "April", "Edward")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

    private static void example2() {

        /* This can help reducing the actual number of operations - instead of
           mapping "Alex", "David", "April", and "Edward" and the anyMatch() on
           "Alex" (5 operations in total), we process the elements vertically resulting in only 2 operations.
           While this is a small example, it shows the benefits to be had if we had millions
           of data elements to be processed
                map: Alex
                anyMatch: ALEX
         */
        Stream.of("Alex", "David", "April", "Edward")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch: " + s);
                    return s.startsWith("A");
                });
    }

    private static void example3() {

        List<String> names =
                Arrays.asList("April", "Ben", "Charlie",
                              "David", "Benildus", "Christian");
        names.stream()
                .peek(System.out::println)
                .filter(s -> {
                    System.out.println("filter1: " + s);
                    return s.startsWith("B") || s.startsWith("C");
                })
                .filter(s -> {
                    System.out.println("filter2: " + s);
                    return s.length() > 3;
                })
                .limit(1) // intermediate operation Stream<T> limit(long)
                .forEach(System.out::println); // terminal operation
    }
}
