package com.phucdevs.lambdas.exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

interface Printable<T> {
    void print(T t);
}

interface Retrievable<T> {
    T retrieve();
}

interface Evaluate<T> {
    boolean isNegative(T t);
}

interface Functionable<T, R> {
    R applyThis(T t);
}

public class BasicLambdas {

    public static void main(String[] args) {

        consumer();
        supplier();
        predicate();
        function();

        List<Person> persons = getPeople();
        sortAge(persons);
        sortName(persons);
        sortHeight(persons);
    }

    public static void consumer() {

        // Printable<T> is a functional interface i.e. one abstract method:
        //      void print(T t); // similar to java.util.function.Consumer
        Printable<String> lambda = s -> System.out.println(s);
        lambda.print("Printable lambda"); // Printable lambda

        // Consumer is a functional interface i.e. one abstract method:
        //      void accept(T t)
        Consumer<String> consumerLB = s -> System.out.println(s); // lambda
        consumerLB.accept("Printable lambda");

        Consumer<String> consumerMR = s -> System.out.println(s); // method reference
        consumerMR.accept("Printable method reference");
    }

    public static void supplier() {

        // Retrievable<T> is a functional interface i.e. one abstract method:
        //      T retrieve(); // similar to java.util.function.Supplier
        Retrievable<Integer> lambda = () -> 77;
        System.out.println("Retrieve = " + lambda.retrieve()); // Retrieve = 77

        // Supplier<T> is a functional interface i.e. one abstract method:
        //      T get()
        Supplier<Integer> supplier = () -> 77;
        System.out.println("Supplier = " + supplier.get()); // Supplier = 77
    }

    public static void predicate() {

        Evaluate<Integer> lambda = n -> n < 0;
        System.out.println("lambda = " + lambda.isNegative(-1) + " and " + lambda.isNegative(+1)); // lambda1 = true

        Predicate<Integer> predicate = n -> n < 0;
        System.out.println("predicate = " + predicate.test(-1) + " and " + predicate.test(+1)); // predicate = true and false

        Predicate<Integer> predicateInteger = n -> n % 2 == 0;
        System.out.println("Number 4 is even: " + check(4, predicateInteger)); // true
        System.out.println("Number 7 is even: " + check(7, predicateInteger)); // false

        Predicate<String> predicateString = s -> s.startsWith("Mr.");
        System.out.println("Mr. Joe Bloggs begins with Mr.: " + check("Mr. Joe Bloggs", predicateString));
        System.out.println("Ms. Ann Bloggs begins with Ms.: " + check("Ms. Ann Bloggs", predicateString));

        Person p1 = new Person("Mike", 33, 1.8);
        Person p2 = new Person("Ann", 13, 1.4);
        Predicate<Person> predicateAge = p -> p.getAge() >= 18;
        System.out.println("p1 is an adult: " + check(p1, predicateAge)); // true
        System.out.println("p2 is an adult: " + check(p2, predicateAge)); // false
    }

    public static <T> boolean check(T t, Predicate<T> predicate) {
        return predicate.test(t);
    }

    public static void function() {

        Functionable<Integer, String> functions = i -> "Number is: " + i;
        System.out.println(functions.applyThis(25));

        Function<Integer, String> function2 = i -> "Number is: " + i;
        System.out.println(function2.apply(25));
    }

    public static List<Person> getPeople() {
        List<Person> result = new ArrayList<>();
        result.add(new Person("Mike", 33, 1.8));
        result.add(new Person("Mary", 25, 1.4));
        result.add(new Person("Alan", 34, 1.7));
        result.add(new Person("Zoe", 30, 1.5));
        return result;
    }

    public static void sortAge(List<Person> persons) {

        //sort by age
        // Note: In Java 8, the List interface supports the sort method directly,
        //       so no need to use Collections.sort anymore.
        persons.sort(
                Comparator.comparing(p -> p.getAge()) // lambda
                // Comparator.comparing(Person::getAge) // methid reference
        );
        System.out.println("Person after be sorted asc by age is : " + persons);
    }

    public static void sortName(List<Person> persons) {

        persons.sort(
                (p1, p2) -> p2.getName().compareTo(p1.getName())
        );
        System.out.println("Person after be sorted desc by name is : " + persons);
    }

    public static void sortHeight(List<Person> persons) {

        persons.sort(
                Comparator.comparing(p -> p.getHeight()) // lambda
                // Comparator.comparing(Person::getHeight) // lambda
        );
        System.out.println("Person after be sorted asc by height is : " + persons);
    }
}

class Person {

    private Integer age;
    private String name;
    private Double height;

    Person(String name, Integer age, Double height) {
        this.age = age;
        this.name = name;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Person{" + "age=" + age + ", name=" + name + ", height=" + height + '}';
    }

    public Double getHeight() {
        return height;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
