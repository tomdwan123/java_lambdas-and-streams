package com.phucdevs.lambdas.bound_method_reference;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class BasicBoundMethodReference {

    public static void main(String[] args) {

        String name = "Mr. Joe Bloggs";
        Supplier<String> lowerL = () -> name.toLowerCase();
        Supplier<String> lowerMR = name::toLowerCase;

        System.out.println(lowerL.get()); // mr. joe bloggs
        System.out.println(lowerMR.get()); // mr. joe bloggs

        // Even though startsWith is overload, boolean startsWith(String) and
        // boolean startsWith(String, int), because we are creating a Predicate
        // which has a functional method of test(T t), the startsWith(String) is used
        // This is where "context" is important
        Predicate<String> titleL = (title) -> name.startsWith(title);
        Predicate<String> titleMR = name::startsWith;

        System.out.println(titleL.test("Mr.")); // true
        System.out.println(titleL.test("Ms.")); // false
    }
}
