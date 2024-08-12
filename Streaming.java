import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Streaming {
    public static void main(String[] args) {
        List<String> strings = List.of("poppie", "kipngeno", "rotich");
        Map<Integer, Long> map = strings.stream()
                                        .collect(Collectors.groupingBy(String::length, Collectors.counting()));

        map.forEach((key, value) -> System.out.println(key + " :: " + value));
    }
}
