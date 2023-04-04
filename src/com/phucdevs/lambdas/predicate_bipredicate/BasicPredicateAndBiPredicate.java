package com.phucdevs.lambdas.predicate_bipredicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BasicPredicateAndBiPredicate {

    public static void main(String[] args) {

        // Predicate with info
        //   Interface: Predicate<T>
        //   Functional method: boolean test(T t)
        //   Used for: when you want to filter/match
        Predicate<String> predicate = s -> s.contains("city");
        System.out.println(predicate.test("Newyork city")); // true

        // BiPredicate with info
        //   Interface: BiPredicate<T, U>
        //   Functional method: boolean test(T t, U u)
        BiPredicate<String, Integer> biPredicate = (str, len) -> str.length() == len;
        System.out.println(biPredicate.test("Newyork city", 8)); // false (length is 12)
    }
}
