package funtionalinterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test_Predicate_BiPredicate {
    //Predicate is often used when filtering or matching
    public static void main(String[] args) {
        Predicate<String> p1 = String::isEmpty;
        Predicate<String> p2 = x -> x.isEmpty();

        System.out.println(p1.test("Hello"));

        BiPredicate<String, String> b1 = String::startsWith;
        BiPredicate<String, String> b2 = (string, prefix) -> string.startsWith(prefix);

        System.out.println(b1.test("Hello", "World"));

        System.out.println("******************************* chainMethods");
        List<String> names = Arrays.asList("Adam", "Alexander", "John", "Tom");

        Predicate<String> predicate1 =  str -> str.startsWith("A");
        Predicate<String> predicate2 =  str -> str.length() < 5;

        List<String> result = names.stream()
                .filter(predicate1.and(predicate2))
                .collect(Collectors.toList());
        System.out.println(result);

        Predicate<String> pre1 =  str -> str.startsWith("J");
        Predicate<String> pre2 =  str -> str.length() < 4;

        List<String> result2 = names.stream()
                .filter(pre1.or(pre2))
                .collect(Collectors.toList());
        System.out.println(result2);
    }
}
