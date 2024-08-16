package funtionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Test_Funtion_BiFuntion {
    //A function is responsible for turning one parameter into a value of a potentially different type and returning it.
    public static void main(String[] args) {
        Function<String, Integer> f1 = s -> s.length();
        Function<String, Integer> f2 = String::length;

        System.out.println(f1.apply("Hello"));

        BiFunction<String, String, String> f3 = String::concat;

        System.out.println(f3.apply("Hello", " World"));

        System.out.println("******************************* chainMethods");

        Function<Integer, Integer> multiply = (value) -> value * 2;
        Function<Integer, Integer> add      = (value) -> value + 3;

        Function<Integer, Integer> addThenMultiply = multiply.compose(add);

        Integer result1 = addThenMultiply.apply(3);
        System.out.println(result1);
    }
}
