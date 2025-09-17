import java.util.Scanner;

public class SubstringComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.next();
        System.out.print("Enter start index: ");
        int start = scanner.nextInt();
        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        String customSubstring = "";
        for (int i = start; i < end && i < text.length(); i++) {
            customSubstring += text.charAt(i);
        }

        String builtInSubstring = text.substring(start, Math.min(end, text.length()));

        boolean areEqual = true;
        if (customSubstring.length() != builtInSubstring.length()) {
            areEqual = false;
        } else {
            for (int i = 0; i < customSubstring.length(); i++) {
                if (customSubstring.charAt(i) != builtInSubstring.charAt(i)) {
                    areEqual = false;
                    break;
                }
            }
        }

        System.out.println("Custom Substring: " + customSubstring);
        System.out.println("Built-in Substring: " + builtInSubstring);
        System.out.println("Are both substrings equal? " + areEqual);
        scanner.close();
    }
}
