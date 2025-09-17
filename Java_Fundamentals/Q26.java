import java.util.Scanner;
public class Q26{
 public static void main(String[] args){
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter Salary: ");
 int s = sc.nextInt();
 System.out.println("Enter bonus: ");
 int b = sc.nextInt();
   int net = s+b;
   System.out.println("The salary is INR "+s+" and the bonus is INR "+b+". Hence Total Income is INR "+net);
}
}