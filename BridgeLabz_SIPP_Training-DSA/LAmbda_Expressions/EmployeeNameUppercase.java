import java.util.*;

public class EmployeeNameUppercase {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Amit", "Riya", "Suresh");

        names.stream()
             .map(String::toUpperCase)
             .forEach(System.out::println);
    }
}
