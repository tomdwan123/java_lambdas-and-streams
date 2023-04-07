package com.phucdevs.streams.exam;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.lang.Integer.max;

public class Q2_1738 {

    public static void main(String[] args) {
        /*
           a. Using 1, 2 and 3 create a List of Integers.
         */
        // ai. Stream the list and calculate the sum, using the sum() method from IntStream.
        int sum = IntStream.of(1, 2, 3).sum();
        System.out.println("sum = " + sum); // 6

        // aii. Stream the list again and calculate the maximum value, using the max() method from IntStream.
        int max = IntStream.of(1, 2, 3).max().getAsInt();
        System.out.println("max = " + max); // 3

        /*
           b. Given the Person class (in the zip file), declare a List typed for Person with the following Person’s:
           Using the max(Comparator) from Stream, calculate the oldest person in the list.
         */
        List<Person> persons = Arrays.asList(
                new Person("Alan", "Burke", 22),
                new Person("Zoe", "Peters", 20),
                new Person("Peter", "Castle", 29)
        );

        Optional<Person> oldestPerson = persons.stream()
                .max(Comparator.comparing(p -> p.getAge()));
        System.out.println("oldest = " + oldestPerson.get());

        /*
           Using 10, 47, 33 and 23 create a List of Integers. Stream the list and
           using the following versions of reduce(), calculate the maximum value:
         */
        // ci. Optional<T> reduce(BinaryOperator<T> accumulator)
        List<Integer> numbers = Arrays.asList(10, 37, 33, 23);
        int max1 = numbers.stream()
                .reduce((a, b) -> max(a, b)).get();
        System.out.println("max1 = " + max1);

        // cii. T reduce(T identity, BinaryOperator<T> accumulator)
        int max2 = numbers.stream()
                .reduce(Integer.MIN_VALUE, (a, b) -> max(a,b));
        System.out.println("max2 = " + max2);
    }
}
