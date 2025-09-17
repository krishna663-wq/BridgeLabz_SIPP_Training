import java.util.Scanner;
public class Q22{
 public static void main(String[] args){
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter temp. in Fahrenheit: ");
 int F = sc.nextInt();
   double C = (F-32)* 5/9;
   System.out.println("The "+C+" fahrenheit is "+C+" Celsius");
}
}