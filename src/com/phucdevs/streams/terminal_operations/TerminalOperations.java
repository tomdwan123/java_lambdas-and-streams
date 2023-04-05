package com.phucdevs.streams.terminal_operations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class TerminalOperations {

    public static void main(String[] args) {

        example1();
        example2();
        example3();
    }

    private static void example1() {

        long count = Stream.of("dog", "cat").count();
        System.out.println(count); // 2

        // Optional<T> min(Comparator)
        // Optional<T> max(Comparator)
        // Optional introduce in Java 8 to replace 'null'. If the stream is empty
        // then the Optional will be empty (and we don't have to deal with null)
        Optional<String> min = Stream.of("deer", "horse", "pig")
                .min((s1, s2) -> s1.length() - s2.length());
        min.ifPresent(System.out::println); // pig

        Optional<Integer> max = Stream.of(4, 6, 2, 12, 9)
                .max((i1, i2) -> i1 - i2);
        max.ifPresent(System.out::println); // 12
    }

    private static void example2 () {

        // Option<T> findAny()
        // Optional<T> findFirst()
        // These are terminal operations but nit reductions
        // as the sometimes return without processing all the elements
        // in the stream. Reductions reduce the entire stream
        // into one value
        Optional<String> any = Stream.of("John", "Paul")
                .findAny();
        any.ifPresent(System.out::println); // John (usually)

        Optional<String> first = Stream.of("John", "Paul")
                .findFirst();
        first.ifPresent(System.out::println); // John
    }

    private static void example3() {

        // boolean anyMatch(Predicate)
        // boolean allMatch(Predicate)
        // boolean noneMatch(Predicate)
        List<String> names = Arrays.asList("Alan", "Brian", "Colin");
        Predicate<String> pred = name -> name.startsWith("A");
        System.out.println(names.stream().anyMatch(pred)); // true -> Alan
        System.out.println(names.stream().allMatch(pred)); // false
        System.out.println(names.stream().noneMatch(pred)); // false
    }

    private static void example4() {

        // void forEach(Consumer)
        // as there is no return value, forEach() is not a reduction
        // As the return type is 'void', if you want something to
        // happen, it has happen inside the Consumer (side-effect)
        Stream<String> names = Stream.of("Cathy", "Pauline", "Zoe");
        names.forEach(System.out::println); // CathyPaulineZoe

        // Notes: forEach is also a method in the Collection interface.
        //      Streams cannot be the source if a for-ech loop
        //      because streams do not implement the iterable interface
        Stream<Integer> s = Stream.of(1);
        // for (Integer i : s) {} // error: required array or Iterable
    }
}
