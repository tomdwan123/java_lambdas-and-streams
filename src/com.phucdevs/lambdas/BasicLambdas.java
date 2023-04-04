package com.phucdevs.lambdas;

interface I {
    void m(); // a functional interface i.e it has only
              // ine abstract method
}

public class BasicLambdas {
    public static void main(String[] args) {
        // pre-Java 8
        I i = new I() {
            @Override
            public void m() {
                System.out.println("I::m() - pre java 8");
            }
        };
        i.m(); // i::m - pre java 8

        // Java 8 - Lambda expression
        I lambdaI = () -> {
            System.out.println("Long lambda version - java 8");
        };
        I lambdaI2 = () -> System.out.println("Short lambda version - java 8");

        lambdaI.m(); // Long lambda version - java 8
        lambdaI2.m(); // Short lambda version - java 8
    }
}
