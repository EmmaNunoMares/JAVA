package streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test_Streams_PuttingTogetherPipeline {
    public static void main(String[] args) {
        /**
         * Get the first two names of our friends alphabetically that are four character longs.
         * */
        var list = List.of("Toby", "Anna", "Leroy", "Alex");
        List<String> filtered = new ArrayList<>();
        for (String name : list) {
            if (name.length() == 4) filtered.add(name);
        }
        Collections.sort(filtered);
        System.out.println(filtered.get(0));
        System.out.println(filtered.get(1));

        var list1 = List.of("Toby", "Anna", "Leroy", "Alex");
        list1.stream()
                .filter(name -> name.length() == 4)
                .sorted()
                .limit(2)
                .forEach(System.out::println);



    }
}
