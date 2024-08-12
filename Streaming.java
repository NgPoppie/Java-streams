import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Streaming {
    public static void main(String[] args) {
        // Creating a stream of strings
        Stream<String> strings = Stream.of("poppie", "kipngeno", "rotich");

        // Count the elements before the terminal operation
        long count = strings.count();
        System.out.println("Count: " + count);

        // Re-create the stream since it's been consumed by the count() method
        strings = Stream.of("poppie", "kipngeno", "rotich");

        // Grouping the strings by their length and counting occurrences
        Map<Integer, Long> map = strings.collect(Collectors.groupingBy(String::length, Collectors.counting()));
        map.forEach((key, value) -> System.out.println(key + " :: " + value));

        // Demonstrating findAny method
        Stream<String> s = Stream.of("car", "doctor", "nurse", "holy");
        Stream<String> infinite = Stream.generate(() -> "closing price");

        s.findAny().ifPresent(System.out::println);
        infinite.findAny().ifPresent(System.out::println);

        // Demonstrating allMatch, anyMatch, and noneMatch methods
        List<String> trades = Arrays.asList("erjpy", "usdjpy", "audjpy");
        Stream<String> srat = Stream.generate(() -> "another trade");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));

        System.out.println(trades.stream().anyMatch(pred));  // true
        System.out.println(trades.stream().allMatch(pred));  // true
        System.out.println(trades.stream().noneMatch(pred)); // false
        System.out.println(srat.anyMatch(pred));  // infinite stream check

        // Filtering the stream and printing elements that start with 'b'
        Stream<String> cars = Stream.of("mercede", "bmw", "gle");
        cars.filter(x -> x.startsWith("b")).forEach(System.out::println);
    }
}
