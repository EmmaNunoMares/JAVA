package test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Testing_Lambdas {
    public static void main(String[] args) {
        //Write a Java program to implement a lambda expression to find the sum of two integers.
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(1, 2));

        //Write a Java program to implement a lambda expression to check if a given string is empty.
        Predicate<String> predicate_00 = String::isEmpty;
        System.out.println(predicate_00.test("Hello"));

        //Write a Java program to implement a lambda expression to convert a list of strings to uppercase and lowercase.
        List<String> stringList = Arrays.asList("Red", "Green", "Blue", "PINK");
        stringList.replaceAll(str -> str.toUpperCase());
        stringList.forEach(s -> System.out.print(s+", "));

        //Write a Java program to implement a lambda expression to filter out even and odd numbers from a list of integers.
        List<Integer> nums00 = Arrays.asList(11, 23, 98, 34, 15, 32, 42, 80, 99, 100);
        List<Integer> numsEven = nums00.stream().filter(number -> number%2==0).collect(Collectors.toList());
        System.out.println();
        numsEven.forEach(s -> System.out.print(s+", "));

        //Write a Java program to implement a lambda expression to find the average of a list of doubles.
        List<Double> nums01 = Arrays.asList(3.5, 7.5, 4.3, 4.7, 5.1);
        Double out = nums01.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        System.out.println();
        System.out.println(out);

        //Write a Java program to implement a lambda expression to check if a given string is a palindrome.
        Predicate<String> predicate_001 = str -> {
            String reverse =  new StringBuilder(str).reverse().toString();
            return reverse.equals(str);
        };
        System.out.println(predicate_001.test("ddedd"));

        //Write a Java program to implement a lambda expression to find the length of the longest and smallest string in a list.
        List < String > colors = Arrays.asList("Red", "Green", "Blue", "Orange", "Black");
        int nimColor = colors.stream().mapToInt(x->x.length()).min().getAsInt();
        int maxColor = colors.stream().mapToInt(x->x.length()).max().getAsInt();
        System.out.println(nimColor+" "+maxColor);

        //Write a Java program to implement a lambda expression to check if a list of strings are all uppercase or all lowercase or mixedcase.
        List < String > strings = Arrays.asList("Java", "JAVA", "java");
        Predicate<String> allUpperCase = str -> str.toUpperCase().equals(str);
        Predicate<String> allLowCase = str -> str.toLowerCase().equals(str);
        boolean up = strings.stream().allMatch(allUpperCase);
        boolean low = strings.stream().allMatch(allLowCase);
        System.out.println(!up && !low);
    }
}