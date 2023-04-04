package com.phucdevs.streams.basic.creating_streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CreatingStreams {

    public static void main(String[] args) {

        //example1();
        //example2();
        //example3();
        //example4();
        //example5();
        example6();
    }

    private static void example1() {

        List<String> animalList = Arrays.asList("cat", "dog", "sheep");
        // using stream() which is a default method in Collection interface
        Stream<String> streamAnimals = animalList.stream();
        System.out.println("Number of elements: " + streamAnimals.count()); // 3

        // stream() is a default method in the Collection interface and therefore
        // is inherited by all classes that implement Collection. Map is NOT one
        // of those i.e. Map is not a Collection. To bridge between the two, we
        // use the Map method entrySet() to return a Set view of the Map
        // (Set IS-A Collection)
        Map<String, Integer> namesToAges = new HashMap<>();
        namesToAges.put("Mike", 22);
        namesToAges.put("Mary", 24);
        namesToAges.put("Alice", 31);
        System.out.println("Number of entries: " +
                namesToAges
                        .entrySet() // get a Set (i.e. Collection) view of the Map
                        .stream() // stream() is a default method in Collection
                        .count() // 3

        );
    }

    private static void example2() {

        Stream<Integer> streamI = Stream.of(1, 2, 3);
        System.out.println(streamI.count()); // 3

        Stream<String> streamS = Stream.of("a", "b", "c", "d");
        System.out.println(streamS.count()); // 4
    }

    private static void example3() {

        List<Cat> cats = loadCats("Cats.txt");
        cats.forEach(System.out::println); // just print the Cat
    }

    private static List<Cat> loadCats(String fileName) {
        List<Cat> cats = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> {
                String[] catsArray = line.split("/");
                cats.add(new Cat(catsArray[0], catsArray[1]));
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return cats;
    }

    private static void example4() {

        Stream<Integer> infStream = Stream.generate(() -> {
            return (int) (Math.random() * 10);
        });

        infStream.forEach(System.out::println);
    }

    private static void example5() {
        // infinite stream of ordered numbers
        //   2, 4, 6, 8, 10, 12 ...
        // iterate(T seed, UnaryOperator<T> fn)
        Stream<Integer> infStream = Stream.iterate(2, n -> n + 2);
        infStream.forEach(System.out::println);
    }

    private static void example6() {
        Stream
                .iterate(2, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
    }
}