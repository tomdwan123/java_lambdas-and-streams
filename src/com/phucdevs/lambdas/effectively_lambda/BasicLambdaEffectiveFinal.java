package com.phucdevs.lambdas.effectively_lambda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class BasicLambdaEffectiveFinal {

    String name = "";

    public static void main(String[] args) {

        List<String> al = new ArrayList<>();
        al.add("John");

        int x = 12; // final or effectively final

        // Lambda take a snapshot/picture of local variables, these local variables
        // MUST NOT change. Only setting up lambda here
        Predicate<String> lambda = s -> {
            // x++;
            new BasicLambdaEffectiveFinal().name = "Kenydy";  // instance/class vars are ok
            System.out.println("x == " + x);
            return s.isEmpty() && x % 2 == 0;
        };
        filterData(al, lambda); // lambda views 'x' as 12
        System.out.println(al);

        new BasicLambdaEffectiveFinal().name = "Sean"; // instance/class vars are ok

        // If 'x' was allowed to change, then the method and the lambda would
        // have 2 different views of 'x'
        // x++;
        filterData(al, lambda); // lambda view 'x' as 12
    }

    private static void filterData(List<String> list, Predicate<String> lambda) {
        Iterator<String> i = list.iterator();
        while (i.hasNext()) {
            i.remove();
        }
    }
}
