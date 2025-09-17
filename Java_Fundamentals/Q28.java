import java.util.Scanner;
public class Q28{
 public static void main(String[] args){
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter no. of chocolates: ");
 int choco = sc.nextInt();
 System.out.println("Enter no. of children: ");
 int child = sc.nextInt();
   int net = choco/child;
   int rem = choco%child;
   System.out.println("The number of chocolates each child gets is "+net+" and the number of remaining chocolates is "+rem);
}
}