@FunctionalInterface
interface FareCalculator {
    double calculateFare(double distance, double rate);
}

public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        FareCalculator taxiFare = (distance, rate) -> distance * rate;
        FareCalculator discountFare = (distance, rate) -> (distance * rate) * 0.9;

        System.out.println("Taxi Fare: ₹" + taxiFare.calculateFare(15, 12));
        System.out.println("Discounted Fare: ₹" + discountFare.calculateFare(15, 12));
    }
}
