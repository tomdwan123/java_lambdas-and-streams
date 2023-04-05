package com.phucdevs.streams.terminal_operations;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TerminalOperationsPrimitiveStreams {

    public static void main(String[] args) {

        example1();
        example2();
        example3();
        example4();
    }

    private static void example1() {

        int[] ia = {1, 2, 3};
        double[] da = {1.1, 2.2, 3.3};
        long[] la = {1L, 2L, 3L};

        IntStream iStream1 = Arrays.stream(ia);
        DoubleStream dStream1 = Arrays.stream(da);
        LongStream lStream1 = Arrays.stream(la);
        System.out.println(iStream1.count() + ", " +
                dStream1.count() + ", " + lStream1.count()); // 3, 3, 3

        IntStream iStream2 = IntStream.of(1, 2, 3);
        DoubleStream dStream2 = DoubleStream.of(1.1, 2.2, 3,3);
        LongStream lStream2 = LongStream.of(1L, 2L, 3L);
        System.out.println(iStream2.count() + ", " +
                dStream2.count() + ", " + lStream2.count()); // 3, 3, 3
    }

    private static void example2() {

        // 1. Using Stream<T> and reduce(identity, accumulator)
        Stream<Integer> numbers = Stream.of(1, 2, 3);
        // Integer reduce(Integer identity, BinaryOperator accumulator)
        //    BinaryOperator extends BiFunction(T, T, T)
        //        T apply(T, T)
        // starting the accumulator with 0
        //        n1 + n2
        //        0 + 1 == 1 (n1 now becomes 1)
        //        1 + 2 = 3 (n1 now becomes 3)
        //        3 + 3 = 6
        System.out.println(numbers.reduce(0, (n1, n2) -> n1 + n2)); // 6

        // 2. Using IntStream and sum()
        // IntStream mapToInt(ToIntFunction)
        //    ToIntFunction is a functional interface:
        //        int applyAsInt(T value);
        IntStream intS = Stream.of(1, 2, 3)
                .mapToInt(n -> n); // unboxed
        int total = intS.sum();
        System.out.println(total); // 6
    }

    private static void example3() {

        OptionalInt max = IntStream.of(10, 20, 30)
                .max();
        max.ifPresent(System.out::println); // 30

        OptionalDouble min = DoubleStream.of(10.0, 20.0, 30.0)
                .min();
        System.out.println(min.orElseThrow()); // 10.0

        OptionalDouble average = LongStream.of(10L, 20L, 30L)
                .average();
        System.out.println(average.orElseGet( () -> Math.random() )); // 20.0
    }

    private static void example4() {

        IntStream numbers = IntStream.of(5, 10, 15, 20);
        IntSummaryStatistics intStats = numbers.summaryStatistics();

        int min = intStats.getMin();
        int max = intStats.getMax();
        double avg = intStats.getAverage();
        long count = intStats.getCount();
        long sum = intStats.getSum();
    }
}
