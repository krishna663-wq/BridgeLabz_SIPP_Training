import java.util.*;

public class SensorReadings {
    public static void main(String[] args) {
        List<Integer> readings = Arrays.asList(20, 55, 80, 30, 90);
        readings.stream()
                .filter(r -> r > 50)
                .forEach(r -> System.out.println("High Reading: " + r));
    }
}
