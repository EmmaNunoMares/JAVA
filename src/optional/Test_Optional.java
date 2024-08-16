package optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Test_Optional {
    public static void main(String[] args) {
        /**
         * Default Value With orElse()
         * */
        String nullName = null;
        String name = Optional.ofNullable(nullName).orElse("john");
        System.out.println(name);

        /**
         * Returning Value With get()
         * */
        Optional<String> opt = Optional.of("baeldung");
        String name_1 = opt.get();
        System.out.println(name_1);

        /**
         * Conditional Return With filter()
         * */
        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        System.out.println(is2016);
        System.out.println(is2017);

        /**
         * Transforming Value With map()
         * */
        List<String> companyNames = Arrays.asList(
                "paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);

        int size = listOptional
                .map(List::size)
                .orElse(0);
        System.out.println(size);

        /**
         * Transforming Value With flatMap()
         */
        Person person = new Person("john", 26);
        Optional<Person> personOptional = Optional.of(person);

        Optional<Optional<String>> nameOptionalWrapper = personOptional.map(Person::getName);
        Optional<String> nameOptional = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
        String name1 = nameOptional.orElse("");

        String name2 = personOptional
                .flatMap(Person::getName)
                .orElse("");

        System.out.println(name1);
        System.out.println(name2);
    }

    public static class Person {
        private String name;
        private int age;
        private String password;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Optional<String> getName() {
            return Optional.ofNullable(name);
        }

        public Optional<Integer> getAge() {
            return Optional.ofNullable(age);
        }

        public Optional<String> getPassword() {
            return Optional.ofNullable(password);
        }
    }
}