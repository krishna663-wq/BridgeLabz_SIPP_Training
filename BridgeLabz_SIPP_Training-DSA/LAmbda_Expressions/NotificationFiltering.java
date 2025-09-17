import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;
    Alert(String type) { this.type = type; }
    public String toString() { return "Alert: " + type; }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("Emergency"),
            new Alert("General"),
            new Alert("Critical"),
            new Alert("Reminder")
        );

        Predicate<Alert> criticalOnly = a -> a.type.equals("Critical") || a.type.equals("Emergency");

        alerts.stream().filter(criticalOnly).forEach(System.out::println);
    }
}
