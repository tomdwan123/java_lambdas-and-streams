package com.phucdevs.streams.terminal_operations;

import java.util.stream.Stream;

public class TerminalOperationsFilterDistinctLimit {

    public static void main(String[] args) {

        example1();
        example2();
        example3();
    }

    private static void example1() {

        // Stream<T> filter(Predicate)
        // The filter() method returns a Stream with the elements that
        // MATCH the given predicate
        Stream.of("galway", "mayo", "roscommon")
                .filter(countyName -> countyName.length() > 5)
                .forEach(System.out::print); // galwayroscommon
    }

    private static void example2() {

        // Stream<T> distinct()
        // distinct() is a  stateful intermediate operation
        // Output: 1.eagle 2.eagle 1.eagle 1.EAGLE 2.EAGLE
        Stream.of("eagle", "eagle", "EAGLE")
                .peek(s -> System.out.println(" 1. " + s))
                .distinct()
                .forEach(s -> System.out.println(" 2." + s));
    }

    private static void example3() {

        // Stream<T> limit(long maxSize)
        // limit is a short-circuiting stateful
        // intermediate operation. Lazy evaluation - 66, 77, 88 and 99
        // are not streamed as they are not needed (limit of 2 i.e. 44 and 55)
        // Output:
        // A - 11 A - 22 A - 33 A - 44 C - 44 A - 55 B - 55 C - 55
        Stream.of(11, 22, 33, 44, 55, 66, 77, 88, 99)
                .peek(n -> System.out.println(" A - " + n))
                .filter(n -> n > 40)
                .peek(n -> System.out.println(" B - " + n))
                .limit(2)
                .forEach(n -> System.out.println(" C - " + n));
    }
}
