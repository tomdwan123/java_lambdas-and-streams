package com.phucdevs.lambdas.predicate;

import java.util.function.Predicate;

public class BasicPredicate {

    public static void main(String[] args) {

        int x = 4;
        int y = 7;
        System.out.println("Is " + x + " even ? " + check(x, n -> n % 2 == 0)); // true
        System.out.println("Is " + y + " even ? " + check(y, n -> n % 2 == 0)); // false

        String male = "Mr.John";
        String female = "Ms.Marry";
        System.out.println("Does " + male + " starts with Mr. ?" +
                check(male, s -> s.startsWith("Mr."))); // true
        System.out.println("Does " + female + " starts with Mr. ?" +
                check(female, s -> s.startsWith("Mr"))); // false
    }

    public static <T> boolean check(T t, Predicate<T> lambda) {
        return lambda.test(t);
    }
}
