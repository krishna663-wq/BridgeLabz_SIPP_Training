import java.lang.reflect.*;
import java.util.Scanner;

public class ClassInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter class name (e.g., java.util.ArrayList): ");
        String className = sc.nextLine();

        try {
            Class<?> clazz = Class.forName(className);

            System.out.println("\nClass: " + clazz.getName());

            System.out.println("\n--- Constructors ---");
            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                System.out.println(constructor);
            }

            System.out.println("\n--- Fields ---");
            for (Field field : clazz.getDeclaredFields()) {
                System.out.println(field);
            }

            System.out.println("\n--- Methods ---");
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        }
    }
}
