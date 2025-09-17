import java.util.*;

interface Category {}

class BookCategory implements Category {
    String genre;
    BookCategory(String genre){ this.genre = genre; }
    public String toString(){ return "BookCategory(" + genre + ")"; }
}

class ClothingCategory implements Category {
    String type;
    ClothingCategory(String type){ this.type = type; }
    public String toString(){ return "ClothingCategory(" + type + ")"; }
}

class GadgetCategory implements Category {
    String brand;
    GadgetCategory(String brand){ this.brand = brand; }
    public String toString(){ return "GadgetCategory(" + brand + ")"; }
}

class Product<C extends Category> {
    String id;
    String name;
    double price;
    C category;
    Product(String id, String name, double price, C category){
        this.id = id; this.name = name; this.price = price; this.category = category;
    }
    public String toString(){
        return id + " " + name + " " + price + " " + category;
    }
}

public class OnlineMarketplace {
    static <P extends Product<?>> void applyDiscount(P product, double percent){
        double newPrice = product.price - (product.price * percent / 100.0);
        product.price = newPrice;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<Product<?>> catalog = new ArrayList<>();
        System.out.println("How many products to add?");
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Choose type 1 Book 2 Clothing 3 Gadget");
            int t = in.nextInt();
            System.out.println("Enter id");
            String id = in.next();
            System.out.println("Enter name");
            String name = in.next();
            System.out.println("Enter price");
            double price = in.nextDouble();
            if(t==1){
                System.out.println("Enter genre");
                String g = in.next();
                catalog.add(new Product<>(id,name,price,new BookCategory(g)));
            } else if(t==2){
                System.out.println("Enter clothing type");
                String c = in.next();
                catalog.add(new Product<>(id,name,price,new ClothingCategory(c)));
            } else {
                System.out.println("Enter brand");
                String b = in.next();
                catalog.add(new Product<>(id,name,price,new GadgetCategory(b)));
            }
        }
        System.out.println("Catalog:");
        for(Product<?> p : catalog) System.out.println(p);
        System.out.println("Enter product id to apply discount");
        String pid = in.next();
        System.out.println("Enter discount percent");
        double pct = in.nextDouble();
        for(Product<?> p : catalog){
            if(p.id.equals(pid)){
                applyDiscount(p,pct);
                System.out.println("Discount applied. New price: " + p.price);
            }
        }
    }
}
