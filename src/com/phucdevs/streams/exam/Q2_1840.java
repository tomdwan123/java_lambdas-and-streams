package com.phucdevs.streams.exam;

import java.util.Arrays;
import java.util.List;

public class Q2_1840 {

    public static void main(String[] args) {

        /*
           This question demonstrates lazy evaluation. Declare the following List<Integer> ls = Arrays.asList(11, 11, 22, 33, 33, 55, 66);
                a. stream the List (note that this is possible because List is a Collection and Collection defines a stream() method);
                   ensure only distinct (unique) numbers are streamed; check if “any match” 11. You should get true for this.
                b. stream the List again (this is necessary because once a stream is closed by a previous terminal operation,
                you must re-create the stream); check to see if “none match” the expression x%11>0.
                Note that the terminal operation noneMatch(Predicate) needs to return false for every element in the stream for noneMatch()
                to return true. In other words, “none of them match this....that’s correct, none of them do; return true”. You should get true here as well.
        */

        List<Integer> ls = Arrays.asList(44, 11, 11, 22, 33, 33, 55, 66);
        boolean match11 = ls.stream()
                .peek(n -> System.out.print(" 1. " + n))
                .distinct()
                .peek(n -> System.out.print(" 2. " + n))
                .anyMatch(n -> n == 11); // 1. 44 2. 44 1. 11 2. 11true
        System.out.println(match11);

        boolean nonmatch11 = ls.stream()
                .peek(n -> System.out.print(" 1. " + n))
                .noneMatch(n -> n % 11 > 0);
        System.out.println(nonmatch11); // 1. 44 1. 11 1. 11 1. 22 1. 33 1. 33 1. 55 1. 66true

    }
}
