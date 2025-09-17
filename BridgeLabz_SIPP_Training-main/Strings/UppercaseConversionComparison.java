import java.util.Scanner;

public class UppercaseConversionComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String customUpper = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                customUpper += (char)(ch - 32);
            } else {
                customUpper += ch;
            }
        }

        String builtInUpper = text.toUpperCase();

        boolean areEqual = customUpper.equals(builtInUpper);

        System.out.println("Custom uppercase: " + customUpper);
        System.out.println("Built-in uppercase: " + builtInUpper);
        System.out.println("Are both uppercase strings equal? " + areEqual);

        scanner.close();
    }
}
