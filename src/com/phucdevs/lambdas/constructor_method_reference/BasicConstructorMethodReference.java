package com.phucdevs.lambdas.constructor_method_reference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class BasicConstructorMethodReference {

    public static void main(String[] args) {

        Supplier<StringBuilder> sbL = () -> new StringBuilder(); // lambda
        Supplier<StringBuilder> sbMR = StringBuilder::new; // method reference
        StringBuilder sb1 = sbL.get().append("lambda version");
        System.out.println(sb1);

        StringBuilder sb2 = sbMR.get().append("method reference version");
        System.out.println(sb2);

        Function<Integer, List<String>> alL = x -> new ArrayList<>(x); // lambda
        Function<Integer, List<String>> alMR = ArrayList::new; // method reference
        List<String> ls1 = alL.apply(10); // size 10
        ls1.add("21");
        System.out.println(ls1); // [21]

        List<String> ls2 = alMR.apply(20); // size 20
        ls2.add("8");
        System.out.println(ls2); // [8]
    }
}
