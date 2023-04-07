package com.phucdevs.lambdas.exam;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdasAndMethodReferences {

    public static void main(String[] args) {

        //staticMR();
        //boundMR();
        //unboundMR();
        constructorMR();
    }

    public static void staticMR() {

        List<Integer> numbers = Arrays.asList(1, 2, 7, 4, 5);
        Consumer<List<Integer>> consumerLB = l -> Collections.sort(l);
        System.out.println("Before sort: " + numbers);
        consumerLB.accept(numbers); // lambda
        System.out.println("After sort: " + numbers);

        numbers = Arrays.asList(1, 2, 7, 4, 5);
        // Collections.sort(List)
        // Collections.sort(List, Comparator)
        // Java infers what to do from the *context* i.e. we are creating a Consumer
        // and its functional method 'accept(T t)' takes one parameter; thus, it
        // invokes the 'sort(List)' as per the lambda syntax above.
        Consumer<List<Integer>> consumerMR = Collections::sort;
        System.out.println("Before sort: " + numbers);
        consumerMR.accept(numbers); // method reference
        System.out.println("After sort: " + numbers);
    }

    public static void boundMR() {

        String name = "Mr.Joe Bloggs";
        Predicate<String> lambda = prefix -> name.startsWith(prefix);
        System.out.println(name + " begins with Mr.: " + lambda.test("Mr."));
        System.out.println(name + " begins with Ms.: " + lambda.test("Ms."));

        Predicate<String> methodReference = name::startsWith;
        System.out.println(name + " begins with Mr.: " + methodReference.test("Mr."));
        System.out.println(name + " begins with Ms.: " + methodReference.test("Ms."));
    }

    public static void unboundMR() {

        Predicate<String> lambda = s -> s.isEmpty();
        System.out.println(lambda.test("")); // true
        System.out.println(lambda.test("xyz")); // false

        Predicate<String> methodReference = String::isEmpty;
        System.out.println(methodReference.test("")); // true
        System.out.println(methodReference.test("xyz")); // false

        BiPredicate<String, String> biPredicateLB = (s1, s2) -> s1.startsWith(s2);
        System.out.println(biPredicateLB.test("Mr. Joe Bloggs", "Mr.")); // true
        System.out.println(biPredicateLB.test("Mr. Joe Bloggs", "Ms.")); // false

        // Now we are working with a "Bi"Predicate i.e. 2 parameters.
        // What does Java do with them? The first argument will always be the instance of the
        // object for instance methods. The second (and other) arguments are method parameters.
        BiPredicate<String, String> biPredicateMR = String::startsWith;
        // Context - BiPredicate takes two args, the first is the one that 'startsWith' will be
        // executed on; the second argument and subsequent arguments are passed in as as
        // arguments to 'startsWith'
        System.out.println(biPredicateMR.test("Mr. Joe Bloggs", "Mr.")); // true
        System.out.println(biPredicateMR.test("Mr. Joe Bloggs", "Ms.")); // false
    }

    public static void constructorMR() {

        Supplier<List<String>> lambda = () -> new ArrayList<>();
        List<String> list = lambda.get();
        list.add("Lambda");
        System.out.println(list); // [Lambda]

        Supplier<List<String>> methodReference = ArrayList::new;
        list = methodReference.get();
        list.add("Method Reference");
        System.out.println(list); // [Lambda]

        Function<Integer, List<String>> functionLB = (n) -> new ArrayList<>(n);
        list = functionLB.apply(10);
        list.add("Lambda");
        System.out.println(list);

        // this is where context is all important:
        //1. the first method reference was for a Supplier and Supplier’s
        //functional method is T get() and thus, Java knew to look for the
        //ArrayList constructor that takes in NO argument
        //2. the first method reference was for a Function and Function’s
        //functional method is R apply(T t) and thus, Java knew to look for
        //the ArrayList constructor that takes in ONE argument.
        Function<Integer, List<String>> functionMR = ArrayList::new;
        list = functionMR.apply(10);
        list.add("Method Reference");
        System.out.println(list);

    }
}
