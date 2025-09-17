import java.util.*;
import java.util.stream.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String paragraph = "Java is powerful and Java is versatile";
        List<String> words = Arrays.asList(paragraph.split(" "));

        Map<String, Long> frequency = words.stream()
            .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        System.out.println(frequency);
    }
}
