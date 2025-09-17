import java.util.*;
import java.util.stream.*;

class Claim {
    String type;
    double amount;
    Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

public class InsuranceClaims {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
                new Claim("Health", 5000),
                new Claim("Car", 8000),
                new Claim("Health", 7000),
                new Claim("Car", 12000),
                new Claim("Life", 15000)
        );

        Map<String, Double> avgClaims = claims.stream()
                .collect(Collectors.groupingBy(c -> c.type, Collectors.averagingDouble(c -> c.amount)));

        avgClaims.forEach((type, avg) -> System.out.println(type + " Avg Claim: " + avg));
    }
}
