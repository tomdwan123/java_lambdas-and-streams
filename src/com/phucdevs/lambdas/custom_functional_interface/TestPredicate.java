package com.phucdevs.lambdas.custom_functional_interface;

import java.util.function.Predicate;

interface Evaluate<T> {
    boolean isNegative(T t);
}

public class TestPredicate {

    public static void main(String[] args) {
        Evaluate<Integer> lambda = i -> i < 0;
        System.out.println("Evaluate: " + lambda.isNegative(-1)); // true
        System.out.println("Evaluate: " + lambda.isNegative(1)); // false

        Predicate<Integer> predicate = i -> i < 0;
        System.out.println("Predicate: " + predicate.test(-1)); // true
        System.out.println("Predicate: " + predicate.test(1)); // false
    }
}
