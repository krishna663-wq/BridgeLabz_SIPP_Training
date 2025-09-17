import java.time.*;
import java.util.*;

public class TransactionLogger {
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList("TXN123", "TXN456", "TXN789");
        transactionIds.forEach(id -> 
            System.out.println(LocalDateTime.now() + " - Transaction: " + id));
    }
}
