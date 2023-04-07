package com.phucdevs.streams.exam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class Q2_1846 {

    public static void main(String[] args) {

        /*
           Given the Book class (in the zip file), declare a List typed for Book with the following Book’s:
                a. title=”Atlas Shrugged”, price=10.0
                b. title=”Freedom at Midnight”, price=5.0
                c. title=”Gone with the wind”, price=5.0
            Stream the books and instantiate a Map named ‘bookMap’ that maps the book title to its price.
            To do this use the collect(Collectors.toMap(Function fnToGetKey, Function fnToGetValue)).
            Iterate through ‘bookMap’ (using the Map forEach(BiConsumer) method).
            The BiConsumer only outputs prices where the title begins with “A”.
         */
        List<Book> books = Arrays.asList(
                new Book("Atlas Shrugged", 10.0),
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the wind", 5.0));

        Map<String, Double> bookMap =
                books.stream()
                .collect(Collectors.toMap(
                        b -> b.getTitle(),
                        b -> b.getPrice()
                ));
        System.out.println("bookMap = " + bookMap);
        BiConsumer<String, Double> biConsumer = (t, p) -> {
            if (t.startsWith("A")) {
                System.out.println(p);
            }
        };
        bookMap.forEach(biConsumer);
    }
}
