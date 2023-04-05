package com.phucdevs.streams.terminal_operations;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class TerminalOperationsMapFlatmapSorted {

    public static void main(String[] args) {

        //example1();
        //example2();
        //example3();
        example4();
    }

    private static void example1() {

        // <R> Stream<R> map(Function<T, R> mapper)
        //       Function's functional method: R apply(T t);
        Stream.of("book", "pen", "ruler")
                .map(String::length)
                .forEach(System.out::println); // 435
    }

    private static void example2() {

        // flatMap() takes each element in the stream
        // e.g. Stream<List<String>> and makes any elements it contains
        // top-level elements in a single stream e.g. Stream<String>
        // flatMap(Function(T, R)) IN:T OUT:R
        // flatMap(List<String>, Stream<String>)
        List<String> str1 = Arrays.asList("sean", "desmond");
        List<String> str2 = Arrays.asList("mary", "ann");
        Stream<List<String>> streamOfLists = Stream.of(str1, str2);
        streamOfLists.flatMap(list -> list.stream())
                .forEach(System.out::println); // seandesmondmaryann
    }

    private static void example3() {

        // Stream<T> sorted(Comparator<T> comparator)
        // Output:
        //  Person{name=John, age=23} Person{name=Mary, age=25}
        Person john = new Person("john", 23);
        Person mary = new Person("mary", 25);
        Stream.of(mary, john)
                .sorted(Comparator.comparing(p -> p.getAge()))
                .forEach(System.out::println);
    }

    private static void example4() {

        // Output:  0.Tim 1.Tim 0.Jim 1.Jim 0.Peter 0.Ann 1.Ann 0.Mary 2.Ann 3.Ann 2.Jim 3.Jim
        Stream.of("Tim", "Jim", "Peter", "Ann", "Mary")
                .peek(name -> System.out.print(" 0." + name))
                .filter(name -> name.length() == 3)
                .peek(name -> System.out.print(" 1." + name))
                .sorted()
                .peek(name -> System.out.print(" 2." + name))
                .limit(2)
                .forEach(name -> System.out.println(" 3." + name));
    }
}

class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
