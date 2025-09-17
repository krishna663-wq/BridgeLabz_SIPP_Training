import java.util.*;

public class StockLogger {
    public static void main(String[] args) {
        List<Double> prices = Arrays.asList(102.5, 105.7, 99.9, 110.2);
        prices.forEach(price -> System.out.println("Stock Price: " + price));
    }
}
