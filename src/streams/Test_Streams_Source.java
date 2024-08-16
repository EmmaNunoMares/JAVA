package streams;

import java.util.stream.Stream;

public class Test_Streams_Source {
    public static void main(String[] args) {
        //Finite stream
        Stream<String> stream1 = Stream.of("a", "b", "c");
        Stream<Integer> stream2 = Stream.empty();
        Stream<Integer> stream3 = Stream.iterate(1, n -> n < 30, i -> i + 2);

        //Infinite Stream
        Stream<Integer> stream4 = Stream.iterate(1, i -> i + 2);
        Stream<Double> stream5 = Stream.generate(Math::random);
        stream3.forEach(System.out::println);

    }
}