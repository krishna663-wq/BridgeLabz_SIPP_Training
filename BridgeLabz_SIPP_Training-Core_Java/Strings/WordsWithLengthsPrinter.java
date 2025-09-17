import java.util.Scanner;

public class WordsWithLengthsPrinter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = scanner.nextLine() + " ";

        String word = "";
        System.out.println("Word\tLength");
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                word += ch;
            } else if (!word.isEmpty()) {
                System.out.println(word + "\t" + word.length());
                word = "";
            }
        }
        scanner.close();
    }
}
