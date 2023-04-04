package com.phucdevs.lambdas.consumer;

import java.util.HashMap;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class BasicConsumer {

    public static void main(String[] args) {
        // Consumer info
        //   Interface: Consumer<T>
        //   Functional method: void accept(T t)
        //   Used for: use the parameter but not interested in the return value
        Consumer<String> printC = s -> System.out.println(s);
        printC.accept("To be or not to be, that is the question");

        List<String> names = List.of("John", "Mary");
        names.forEach(printC);

        // BiConsumer info
        //   Interface: BiConsumer<T, U>
        //   Functional method: void accept(T t, U u)
        var mapCapitalCities = new HashMap<String, String>();
        BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value);
        biCon.accept("HaNoi", "VietNam");
        biCon.accept("Paris", "France");
        System.out.println(mapCapitalCities);

        BiConsumer<String, String> mapPrint = (key, value) ->
                System.out.println(key + " is the capital of " + value);
        mapCapitalCities.forEach(mapPrint);
    }
}
