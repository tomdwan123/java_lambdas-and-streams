package com.phucdevs.lambdas.method_reference;

import java.util.List;

public class BasicMethodReferences {

    public static void main(String[] args) {
        // Consumer
        List<String> names = List.of("Sean", "Mary", "John");
        names.forEach(name -> System.out.println(name)); // lambda
        names.forEach(System.out::println); // method reference
    }
}
