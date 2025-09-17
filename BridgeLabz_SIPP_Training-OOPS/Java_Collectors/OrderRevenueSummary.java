import java.util.*;
import java.util.stream.*;

class Order {
    String customer;
    double total;
    Order(String customer, double total) {
        this.customer = customer;
        this.total = total;
    }
    public String getCustomer() { return customer; }
    public double getTotal() { return total; }
}

public class OrderRevenueSummary {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
            new Order("Ravi", 2500),
            new Order("Ravi", 1500),
            new Order("Sita", 3000),
            new Order("Mohan", 1200)
        );

        Map<String, Double> revenue = orders.stream()
            .collect(Collectors.groupingBy(Order::getCustomer,
                     Collectors.summingDouble(Order::getTotal)));

        System.out.println(revenue);
    }
}
