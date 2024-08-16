package funtionalinterface;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class Test_UnaryOperator_BinaryOperator {
    //They required all type parameters to be the same type
    //UnaryOperation extend from Function
    public static void main(String[] args) {
        UnaryOperator<String> u1 = String::toUpperCase;
        System.out.println(u1.apply("Hello"));

        BinaryOperator<String> b1 = String::concat;
        System.out.println(b1.apply("hello", " world"));
    }
}
