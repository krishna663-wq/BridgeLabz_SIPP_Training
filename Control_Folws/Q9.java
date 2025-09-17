import java.util.Scanner;
public class SumNaturalWhileCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number > 0) {
            int sum = 0, i = 1;
            while (i <= number) {
                sum += i;
                i++;
            }
            int formula = number * (number + 1) / 2;
            System.out.println("Sum by while loop: " + sum);
            System.out.println("Sum by formula: " + formula);
        } else {
            System.out.println("Not a natural number");
        }
    }
}