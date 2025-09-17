class Order {
    private final int id;
    Order(int id) { this.id = id; }
    public int getId() { return id; }
}

interface PaymentProcessor {
    void pay(Order o);
    default boolean refund(Order o, double amount) {
        System.out.println("Default refund for order: " + o.getId() + " amount ₹" + amount);
        return true;
    }
    static String manName() { return "PaymentProcessor v1"; }
}

class PaypalProcessor implements PaymentProcessor {
    @Override
    public void pay(Order o) {
        System.out.println("Paid using PayPal for order: " + o.getId());
    }
    @Override
    public boolean refund(Order o, double amount) {
        System.out.println("PayPal refund failed for order: " + o.getId());
        return false;
    }
}

public class PaymentDemo {
    public static void main(String[] args) {
        Order order = new Order(101);
        PaymentProcessor processor = new PaypalProcessor();
        processor.pay(order);
        processor.refund(order, 500);
        System.out.println(PaymentProcessor.manName());
    }
}
