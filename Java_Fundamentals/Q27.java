import java.util.Scanner;
public class Q27{
 public static void main(String[] args){
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter temp. in Celsius: ");
 int c = sc.nextInt();
   double f = c * (9/5) + 32;
   System.out.println("The "+c+" celsius is "+f+" fahrenheit");
}
}