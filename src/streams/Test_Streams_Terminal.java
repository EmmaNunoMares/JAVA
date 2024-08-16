package streams;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test_Streams_Terminal {
    public static void main(String[] args) {
        /**
         * count()
         * it determines the number of elements in a finite stream. For an infinite stream, it never terminates.
         * Why? count from 1 to inifinity and let us know when you are finished.
         * For infinitive streams does not terminate
         * */
        System.out.println("------------ count");
        Stream<String> stream1 = Stream.of("a", "b", "c");
        System.out.println(stream1.count());

        /**
         * min() and max()
         * For infinitive streams does not terminate.
         * */
        System.out.println("------------ min() and max()");
        Stream<String> stream2 = Stream.of("monkey", "ape", "bonobo");
        Optional<String> optional = stream2.min((s1, s2) -> s1.length() - s2.length());
        optional.ifPresent(System.out::println);

        /**
         * findAny() and findFirst()
         * These methods are terminal operations but not reductions.
         * The reason is that they sometimes return without processing all of the elements.
         * For infinitive stream terminates.
         * */
        System.out.println("------------ findAny() and findFirst()");
        Stream<String> stream3 = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> stream4 = Stream.generate(() -> "chimp");
        stream3.findAny().ifPresent(System.out::println);
        stream4.findAny().ifPresent(System.out::println);

        /**
         * allMatch(), anyMatch() and nonMatch()
         * These methods search a stream and return information about how the stream pertains to the predicate.
         * For infinitive sometimes terminate.
         * */
        System.out.println("------------ allMatch(), anyMatch() and nonMatch()");
        var list = List.of("monkey", "2", "chimp");
        Stream<String> stream5 = Stream.generate(() -> "chimp");
        Predicate<String> p1 = x -> Character.isLetter(x.charAt(0));

        System.out.println(list.stream().anyMatch(p1));
        System.out.println(list.stream().allMatch(p1));
        System.out.println(list.stream().noneMatch(p1));
        System.out.println(stream5.anyMatch(p1));

        /**
         * forEach()
         * For infinite streams does not terminate.
         * */
        System.out.println("------------ forEach()");
        Stream<String> stream6 = Stream.of("monkey ", "gorilla ", "bonobo ");
        stream6.forEach(System.out::print);
        System.out.println();

        /**
         * reduce()
         * This method combines a stream into a single object. It's a reduction, which means it process all elements.
         * For infinite streams does not terminate.
         * */
        System.out.println("------------ reduce()");
        var array = new String[]{"w", "o", "l", "f"};
        var result = "";
        for (String s : array) result += s;
        System.out.println(result);

        Stream<String> stream7 = Stream.of("w", "o", "l", "f");
        System.out.println(stream7.reduce("", String::concat));

        Stream<Integer> stream8 = Stream.of(3, 5, 6);
        System.out.println(stream8.reduce(1, (a, b) -> a * b));

        /**
         * collect()
         * it let us get data out of stream and into another form.
         * For infinitive streams does not terminate.
         * */
        System.out.println("------------ collect()");
        Stream<String> stream9 = Stream.of("w", "o", "l", "f");
        StringBuilder words = stream9.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(words);

        Stream<String> stream10 = Stream.of("w", "o", "l", "f");
        TreeSet<String> treeSet = stream10.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(treeSet);

        Stream<String> stream11 = Stream.of("w", "o", "l", "f");
        Set<String> set = stream11.collect(Collectors.toSet());
        System.out.println(set);
    }
}