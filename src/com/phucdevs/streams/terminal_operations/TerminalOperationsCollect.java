package com.phucdevs.streams.terminal_operations;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsCollect {

    public static void main(String[] args) {

        example1();
        example2();
        example3();
        example4();
        example5();
        example6();
        example7();
        example8();
        example9();
        example10();
    }

    private static void example1() {

        // StringBuilder collect(Supplier<StringBuilder> supplier,
        //                  BiConsumer<StringBuilder, String> accumulator,
        //                  BiConsumer<StringBuilder, StringBuilder> combiner)
        // This version is used when you want complete control over
        // how collecting should work. The accumulator adds an element
        // to the collection e.g. the next String to the StringBuilder.
        // The combiner takes two collections and merges them. It is useful
        // in parallel processing.
        StringBuilder word = Stream.of("ad", "jud", "i", "cate")
                .collect(() -> new StringBuilder(),
                        (sb, str) -> sb.append(str),
                        (sb1, sb2) -> sb1.append(sb2));
        System.out.println(word); // adjudicate
    }

    private static void example2() {

        String s = Stream.of("cake", "biscuits", "apple tart")
                .collect(Collectors.joining(", "));
        System.out.println(s); // cake, biscuits, apple tart

        Double avg = Stream.of("cake", "biscuits", "apple tart")
                .collect(Collectors.averagingInt(sa -> sa.length()));
        System.out.println(avg); // 7.333333333333333
    }

    private static void example3() {

        // We want a map: dessert name -> number of characters in dessert name
        // Output:
        //   {biscuits=8, cake=4, apple tart-10}
        Map<String, Integer> map =
                Stream.of("cake", "biscuits", "apple tart")
                .collect(
                        Collectors.toMap(
                                s -> s,  // Function for the key
                                s -> s.length() // Function for the value
                        )
                );
        System.out.println(map);
    }

    private static void example4() {

        Map<Integer, String> map =
                Stream.of("cake", "biscuits", "tart")
                .collect(
                        Collectors.toMap(
                                s -> s.length(), // key is the length
                                s -> s,          // value is the String
                                (s1, s2) -> s1 + "," + s2 // Merge function - what to
                                                          // do if we have duplicate keys
                                                          //   - append the values
                        )
                );
        System.out.println(map); // {4=cake,tart, 8-biscuits}
    }

    private static void example5() {

        TreeMap<String, Integer> map =
                Stream.of("cake", "biscuits", "apple tart", "cake")
                .collect(
                        Collectors.toMap(
                                s -> s,  // key is the String
                                s -> s.length(), // value is the length of the String
                                (len1, len2) -> len1 + len2, // what to do if we have
                                                             // duplicate keys
                                                             //   - add the *values*
                                () -> new TreeMap<>()
                        )
                );
        System.out.println(map); // {apple tart = 10, biscuits = 8, cake=8} Note: cake maps to 8
    }

    private static void example6() {

        Stream<String> names = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        Map<Integer, List<String>> map =
                names.collect(
                        Collectors.groupingBy(String::length)
                );
        System.out.println(map); // {3=[Joe, Tom, Tom], 4=[Alan], 5=[Peter]}
    }

    private static void example7() {

        Stream<String> names = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        Map<Integer, Set<String>> map =
                names.collect(
                        Collectors.groupingBy(
                                String::length,
                                Collectors.toSet())
                );
        System.out.println(map); // {3=[Joe,Tom], 4=[Alan], 5=[Peter]}
    }

    private static void example8() {

        Stream<String> names = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        TreeMap<Integer, List<String>> map =
                names.collect(
                        Collectors.groupingBy(
                                String::length,
                                TreeMap::new,
                                Collectors.toList())
                );
        System.out.println(map); // {3=[Joe, Tom, Tom], 4=[Alan], 5=[Peter]}
    }

    private static void example9() {

        Stream<String> names = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");
        Map<Boolean, List<String>> map =
                names.collect(
                        Collectors.partitioningBy(s -> s.startsWith("T"))
                );
        System.out.println(map); // {false=[Mike, Alan, Peter], true=[Thomas, Teresa]}
    }

    private static void example10() {

        Stream<String> names = Stream.of("Alan", "Teresa", "Mike", "Alan", "Peter");
        Map<Boolean, Set<String>> map =
                names.collect(
                        Collectors.partitioningBy(
                                s -> s.length() > 4, // predicate
                                Collectors.toSet())
                );
        System.out.println(map); // {false=[Alan, Mike], true=[Teresa, Peter]}
    }
}
