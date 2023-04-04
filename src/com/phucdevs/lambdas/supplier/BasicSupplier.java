package com.phucdevs.lambdas.supplier;

import java.time.LocalTime;
import java.util.function.Supplier;

public class BasicSupplier {

    public static void main(String[] args) {
        // Supplier with info
        //   Interface: Supplier<T>
        //   Functional method: T get()
        //   Used for: when you want to supply values without any input

        Supplier<StringBuilder> supSB = () -> new StringBuilder();
        System.out.println("Supplier SB: " + supSB.get().append("SK")); // Supplier SB: SK

        Supplier<LocalTime> supTime = () -> LocalTime.now();
        System.out.println("Suplier time: " + supTime.get());

        Supplier<Double> supRandom = () -> Math.random();
        System.out.println("Supplier random: " + supRandom.get());
    }
}
