package com.phucdevs.lambdas.predicate_bipredicate;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class BasicPredicateAndBiPredicate {

    public static void main(String[] args) {

        Predicate<String> predicate = s -> s.contains("city");
        System.out.println(predicate.test("Newyork city")); // true

        BiPredicate<String, Integer> biPredicate = (str, len) -> str.length() == len;
        System.out.println(biPredicate.test("Newyork city", 8)); // false (length is 12)
    }
}
