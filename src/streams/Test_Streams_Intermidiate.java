package streams;

import java.util.List;
import java.util.stream.Stream;

public class Test_Streams_Intermidiate {
    public static void main(String[] args) {
        /**
         * An intermediate operation produces a stream as its result.
         * */
        /**
         * filter()
         * It returns a stream with elements that match a given expression
         * */
        System.out.println("------------ filter()");
        Stream<String> stream1 = Stream.of("monkey ", "gorilla ", "bonobo ");
        stream1.filter(x -> x.startsWith("m"))
                .forEach(System.out::print);
        System.out.println();

        /**
         * distinct()
         * It returns a stream with duplicate values removed.
         * */
        System.out.println("------------ distinct()");
        Stream<String> stream2 = Stream.of("duck ", "duck ", "duck ", "goose ");
        stream2.distinct()
                .forEach(System.out::print);
        System.out.println();

        /**
         * limit() and skip()
         * Can make a stream smaller, or they could make a finite stream out of an infinite stream.
         * */
        System.out.println("------------ limit() and skip()");
        Stream<Integer> stream3 = Stream.iterate(1, x -> x + 1);
        stream3.skip(5).limit(2).forEach(System.out::println);

        /**
         * map()
         * it creates a one-to-one mapping from the elements in
         * the stream to the elements of the next step in the stream.
         * It's for transforming data.
         * */
        System.out.println("------------ map()");
        Stream<String> stream4 = Stream.of("monkey ", "gorilla ", "bonobo ");
        stream4.map(String::length)
                .forEach(System.out::println);

        /**
         * flatMap()
         * it takes each element in the stream and makes any elements
         * it contains top-level elements in a single stream.
         * Helpful to remove empty elements from a stream or you want to combine a stream of list.
         * */
        System.out.println("------------ flatMap()");
        List<String> zero = List.of();
        var one = List.of("Bonobo");
        var two = List.of("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);
        animals.flatMap(m -> m.stream())
                .forEach(System.out::println);

        /**
         * sorted()
         * it returns a stream with the elements sorted.         *
         * */
        System.out.println("------------ sorted()");
        Stream<String> stream5 = Stream.of("c", "b", "a");
        stream5.sorted().forEach(System.out::println);

        /**
         * peek()
         * it helps for debugging because it allows to perform a stream
         * operation without actually changing the stream.
         * */
        System.out.println("------------ peek()");
        Stream<String> stream6 = Stream.of("bb", "cc", "gg");
        long count = stream6.filter(x -> x.startsWith("g")).peek(System.out::println).count();
        System.out.println(count);

    }
}