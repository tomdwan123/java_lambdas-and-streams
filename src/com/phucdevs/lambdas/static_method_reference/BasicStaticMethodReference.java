package com.phucdevs.lambdas.static_method_reference;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class BasicStaticMethodReference {

    public static void main(String[] args) {

        Consumer<List<Integer>> sortL = list -> Collections.sort(list); // lambda
        Consumer<List<Integer>> sortMR = Collections::sort; // method reference

        List<Integer> listOfNumbers1 = Arrays.asList(2, 1, 4, 5, 9);
        sortL.accept(listOfNumbers1);
        System.out.println(listOfNumbers1); // [1, 2, 4, 5, 9]

        List<Integer> listOfNumbers2 = Arrays.asList(8, 12, 4, 3, 7);
        sortMR.accept(listOfNumbers2);
        System.out.println(listOfNumbers2); // [3, 4, 7, 8, 12]
    }
}
