import java.util.*;
import java.util.stream.*;

public class CustomerNames {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ravi", "Amit", "Neha", "Karan");

        names.stream()
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
