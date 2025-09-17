import java.util.*;

class Product {
    String name;
    double price;
    double rating;

    Product(String name, double price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String toString() {
        return name + " (₹" + price + ", Rating: " + rating + ")";
    }
}

public class ProductSorting {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 60000, 4.5),
            new Product("Phone", 30000, 4.8),
            new Product("Tablet", 20000, 4.2)
        );

        System.out.println("Sorted by Price:");
        products.stream().sorted((p1, p2) -> Double.compare(p1.price, p2.price)).forEach(System.out::println);

        System.out.println("\nSorted by Rating:");
        products.stream().sorted((p1, p2) -> Double.compare(p2.rating, p1.rating)).forEach(System.out::println);
    }
}
