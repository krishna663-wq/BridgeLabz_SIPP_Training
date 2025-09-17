public class PalindromeStringChecker {
    String text;

    // Constructor to initialize text
    public PalindromeStringChecker(String text) {
        this.text = text;
    }

    // Method to check if the text is a palindrome
    public boolean isPalindrome() {
        String cleaned = text.replaceAll("\s+", "").toLowerCase(); // remove spaces and convert to lowercase
        String reversed = new StringBuilder(cleaned).reverse().toString(); // reverse the string
        return cleaned.equals(reversed); // compare original and reversed
    }

    // Method to display result
    public void displayResult() {
        System.out.println("Text: " + text);
        System.out.println("Is Palindrome: " + isPalindrome());
    }

    // Main method to test the class
    public static void main(String[] args) {
        PalindromeStringChecker checker = new PalindromeStringChecker("madam");
        checker.displayResult();
    }
}