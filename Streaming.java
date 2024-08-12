import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Streaming {
    public static void main(String[] args) {
        Stream<String> strings = Stream.of("poppie", "kipngeno", "rotich");

        // Count the elements before the terminal operation
        long count = strings.count();
        System.out.println("Count: " + count);

        // Re-create the stream since it's been consumed by the count() method
        strings = Stream.of("poppie", "kipngeno", "rotich");
        
        Map<Integer, Long> map = strings.collect(Collectors.groupingBy(String::length, Collectors.counting()));
        
        map.forEach((key, value) -> System.out.println(key + " :: " + value));
    }
}
