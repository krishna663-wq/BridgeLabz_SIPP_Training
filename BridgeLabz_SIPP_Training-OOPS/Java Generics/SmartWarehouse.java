import java.util.*;

abstract class WarehouseItem {
    String id;
    String name;
    WarehouseItem(String id, String name){
        this.id = id;
        this.name = name;
    }
    public String toString(){
        return "[" + id + "] " + name + " (" + this.getClass().getSimpleName() + ")";
    }
}

class Electronics extends WarehouseItem {
    Electronics(String id, String name){ super(id, name); }
}

class Groceries extends WarehouseItem {
    Groceries(String id, String name){ super(id, name); }
}

class Furniture extends WarehouseItem {
    Furniture(String id, String name){ super(id, name); }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    void add(T item){ items.add(item); }
    List<T> getAll(){ return items; }
    boolean removeById(String id){
        return items.removeIf(i -> i.id.equals(id));
    }
}

public class SmartWarehouse {
    static void displayAll(List<? extends WarehouseItem> list){
        if(list.isEmpty()) System.out.println("No items to display");
        for(WarehouseItem w : list) System.out.println(w);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        Storage<Electronics> elect = new Storage<>();
        Storage<Groceries> groc = new Storage<>();
        Storage<Furniture> furn = new Storage<>();
        while(true){
            System.out.println("1 Add Item 2 Display All 3 Remove Item 4 Exit");
            int ch = in.nextInt();
            if(ch==4) break;
            if(ch==1){
                System.out.println("Choose type 1 Electronics 2 Groceries 3 Furniture");
                int t = in.nextInt();
                System.out.println("Enter id");
                String id = in.next();
                System.out.println("Enter name (single token)");
                String name = in.next();
                if(t==1) elect.add(new Electronics(id,name));
                else if(t==2) groc.add(new Groceries(id,name));
                else if(t==3) furn.add(new Furniture(id,name));
                System.out.println("Added");
            } else if(ch==2){
                System.out.println("Electronics:");
                displayAll(elect.getAll());
                System.out.println("Groceries:");
                displayAll(groc.getAll());
                System.out.println("Furniture:");
                displayAll(furn.getAll());
            } else if(ch==3){
                System.out.println("Enter type to remove from 1 Electronics 2 Groceries 3 Furniture");
                int t = in.nextInt();
                System.out.println("Enter id to remove");
                String id = in.next();
                boolean removed = false;
                if(t==1) removed = elect.removeById(id);
                else if(t==2) removed = groc.removeById(id);
                else if(t==3) removed = furn.removeById(id);
                System.out.println(removed ? "Removed" : "Not found");
            }
        }
    }
}
