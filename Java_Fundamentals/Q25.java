import java.util.Scanner;
public class Q25{
 public static void main(String[] args){
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter 1st no.: ");
 int a = sc.nextInt();
 System.out.println("Enter 2nd no.: ");
 int b = sc.nextInt();
   int temp = a;
   a=b;
   b=temp;
   System.out.println("The swapped numbers are "+a+" and "+b);
}
}