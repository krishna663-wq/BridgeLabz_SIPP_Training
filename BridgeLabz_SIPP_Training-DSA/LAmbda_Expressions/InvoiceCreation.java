import java.util.*;
import java.util.stream.Collectors;

class Invoice {
    int transactionId;
    Invoice(int id) { this.transactionId = id; }
    public String toString() { return "Invoice for Transaction: " + transactionId; }
}

public class InvoiceCreation {
    public static void main(String[] args) {
        List<Integer> transactionIds = Arrays.asList(201, 202, 203);

        List<Invoice> invoices = transactionIds.stream()
                                               .map(Invoice::new)
                                               .collect(Collectors.toList());

        invoices.forEach(System.out::println);
    }
}
