package com.phucdevs.streams.terminal_operations;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class TerminalOperationsOptional {

    public static void main(String[] args) {

        example1();
        example2();
        example3();
    }

    private static void example1() {

        Optional<Double> optAvg = calcAverage(50, 60, 70);
        if (optAvg.isPresent()) {
            System.out.println(optAvg.get()); // 6.0
        }

        System.out.println(optAvg.orElse(Double.NaN)); // 60.0

        Optional<Double> optAvg2 = calcAverage();
        System.out.println(optAvg2.orElse(Double.NaN)); // NaN
        System.out.println(optAvg2.orElseGet(() -> Math.random()));
    }

    private static Optional<Double> calcAverage(int... scores) {

        if (scores.length == 0) return Optional.empty();
        int sum = 0;
        for (int score : scores) sum += score;
        return Optional.of((double) sum / scores.length);
    }

    private static void example2() {

        Optional<String> optSK = howToDealWithNull("SK");
        optSK.ifPresent(System.out::println); // SK
        Optional<String> optNull = howToDealWithNull(null);
        System.out.println(
                optNull.orElseGet(
                        () -> "Empty optional")); // Empty optional
    }

    private static Optional<String> howToDealWithNull(String param) {
        // Optional optReturn = param == null ? Optional.empty() : Optional.of(param);
        Optional optReturn = Optional.ofNullable(param); // same the previous line
        return optReturn;
    }

    private static void example3() {

        OptionalDouble optAvg = IntStream.rangeClosed(1, 10)
                .average();
        optAvg.ifPresent( (d) -> System.out.println(d)); // 5.5
        System.out.println(optAvg.getAsDouble()); // 5.5
        System.out.println(optAvg.orElseGet(() -> Double.NaN)); // 5.5
    }
}
