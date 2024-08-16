package funtionalinterface;

import java.time.LocalDate;
import java.util.function.Supplier;

public class Test_Supplier {
    //A supplier is used when you want to generate or supply values without taking any input

    public static void main(String[] args) {

        Supplier<LocalDate> d1 = LocalDate::now;
        Supplier<LocalDate> d2 = () -> LocalDate.now();

        System.out.println(d1.get());
    }
}
