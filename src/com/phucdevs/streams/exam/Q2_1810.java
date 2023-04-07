package com.phucdevs.streams.exam;

import java.util.Arrays;
import java.util.List;

public class Q2_1810 {

    public static void main(String[] args) {

        /*
            Given the Person class (in the zip file), declare a List typed for Person with the following Person’s:
            a. name=”Bob”, age=31
            b. name=”Paul”, age=32
            c. name=”John”, age=33
            Pipeline the following where the return type is double:
                 stream the people
                 filter the stream for Person’s whose age is < 30
                 map to int primitives
                 calculate the average age.
            This should generate a NoSuchElementException. Using orElse(), fix the pipeline (not the filter) so that 0.0 is returned instead of an exception being generated.
        */
        List<Person> persons = Arrays.asList(
                new Person("Bob", "Kelly", 31),
                new Person("Paul", "Landers", 32),
                new Person("John", "Paters", 33) );

        double avg = (int) persons.stream()
                .filter(p -> p.getAge() < 30)
                .mapToInt(p -> p.getAge())
                .average()
                .orElse(0.0);
        System.out.println("avg = " + avg);
    }
}
