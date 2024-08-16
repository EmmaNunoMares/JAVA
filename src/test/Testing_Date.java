package test;

import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Testing_Date {
    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());

        LocalDate ld1 = LocalDate.of(2024, Month.JANUARY, 01);
        System.out.println(ld1);
        System.out.println(ld1.getDayOfWeek());
        System.out.println(ld1.getMonth());
        System.out.println(ld1.getYear());
        System.out.println(ld1.format(DateTimeFormatter.ISO_LOCAL_DATE));

        var dtf = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
        System.out.println(LocalDateTime.now().format(dtf));

        //Dates
        Period p1 = Period.between(LocalDate.of(2024, Month.JANUARY, 13), LocalDate.now());
        System.out.println(p1.getMonths() + " months, " + p1.getDays() + " days");

        //Time
        LocalTime initialTime = LocalTime.of(6, 30, 0);
        LocalTime finalTime = initialTime.plus(Duration.ofSeconds(30));
        long thirty = Duration.between(initialTime, finalTime).getSeconds();
        System.out.println(thirty+" Seconds");

        System.out.println(LocalDate.of(2015, 02, 20));
        System.out.println(LocalDate.parse("2015-02-20"));

        System.out.println(LocalTime.parse("06:30"));
        System.out.println(LocalTime.of(6, 30));

        System.out.println(LocalDateTime.of(2015, Month.FEBRUARY, 20, 06, 30));
        System.out.println(LocalDateTime.parse("2015-02-20T06:30:00"));

        System.out.println("Tomorrow = " + LocalDate.now().plusDays(1));
        System.out.println("previousMonthSameDay = " + LocalDate.now().minus(1, ChronoUnit.MONTHS));

    }
}
