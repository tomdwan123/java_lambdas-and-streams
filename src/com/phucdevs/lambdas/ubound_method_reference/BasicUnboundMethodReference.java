package com.phucdevs.lambdas.ubound_method_reference;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BasicUnboundMethodReference {

    public static void main(String[] args) {

        Function<String, String> upperL = s -> s.toUpperCase(); // lambda
        Function<String, String> upperMR = String::toUpperCase; // method reference
        System.out.println(upperL.apply("sean")); // SEAN
        System.out.println(upperMR.apply("sean")); // SEAN

        BiFunction<String, String, String> concatL = (s1, s2) -> s1.concat(s2); // lambda
        BiFunction<String, String, String> concatMR = String::concat; // method reference
        System.out.println(concatL.apply("Sean ", "Tom")); // Sean Tom
        System.out.println(concatMR.apply("Sean ", "Tom")); // Sean Tom
    }
}
