import java.util.Scanner;
public class Q19{
 public static void main(String[] args){
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter weight in pound: ");
 int weight_P = sc.nextInt();
   double weight_K = 2.2*weight_P;
   System.out.println("The weight of the person in pounds is "+weight_P+" and in kg is "+weight_K);
}
}