package com.phucdevs.streams.exam;

import java.util.Arrays;
import java.util.List;

public class Q2_1809 {

    public static void main(String[] args) {

        /*
            Given the Book class (in the zip file), declare a List typed for Book with the following Book’s:
                a. title=”Thinking in Java”, price=30.0
                b. title=”Java in 24 hrs”, price=20.0
                c. title=”Java Recipes”, price=10.0
            Stream the books and calculate the average price of the books whose price is > 10.
            Change the filter to books whose price is > 90. Ensure you do not get an exception.
         */
        List<Book> books = Arrays.asList(
                new Book("Thinking in Java", 30.0),
                new Book("Java in 24 hrs", 20.0),
                new Book("Java Recipes", 10.0)
        );

        double avgPriceMoreTen = books.stream()
                .filter(b -> b.getPrice() > 10)
                .mapToDouble(b -> b.getPrice())
                .average()
                .orElse(0.0);
        System.out.println("avgPriceMoreTen = " + avgPriceMoreTen); // 25.5
    }
}
