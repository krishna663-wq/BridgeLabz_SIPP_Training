import java.util.ArrayList;
import java.util.List;

public class SuppressWarningExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Hello");
        list.add(100);
        System.out.println(list);
    }
}
