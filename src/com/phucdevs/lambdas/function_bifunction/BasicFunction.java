package com.phucdevs.lambdas.function_bifunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BasicFunction {

    public static void main(String[] args) {

        // Function with info
        //   Interface: Function<T, R>
        //   Functional method: R apply(T, t)
        //   Used for: transform the input into an output (types can be different)
        Function<String, Integer> fn = s -> s.length();
        System.out.println("Function: " + fn.apply("Hello function")); // 14

        // BiFunction with info
        //   Interface: BiFunction<T, U, R>
        //   Functional method: R apply(T t, U u, R r)
        BiFunction<String, String, Integer> biFn = (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction: " + biFn.apply("Tom", "John")); // 7

        BiFunction<String, String, String> biFn2 = (s1, s2) -> s1.concat(s2);
        System.out.println("BiFunction: " + biFn2.apply("Cr7 and", "M10")); // Cr7 and M10
    }
}
