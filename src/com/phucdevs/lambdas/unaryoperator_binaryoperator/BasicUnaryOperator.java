package com.phucdevs.lambdas.unaryoperator_binaryoperator;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class BasicUnaryOperator {

    public static void main(String[] args) {

        // UnaryOperator with info
        //   Interface: UnaryOperator<T>
        //   Functional method: T apply(T t)
        //   Used for: transform the input into an output (types are the same)
        UnaryOperator<String> unaryOperator = name -> "My name is " + name;
        System.out.println("UnaryOperator: " + unaryOperator.apply("Tom"));

        // BinaryOperator with info
        //   Interface: BinaryOperator<T>
        //   Functional method: T apply(T t1, T t2)
        BinaryOperator<String> binaryOperator = (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator: " + binaryOperator.apply("Male", "Female"));
    }
}
