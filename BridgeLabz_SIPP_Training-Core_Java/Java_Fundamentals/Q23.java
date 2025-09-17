import java.util.Scanner;
public class Q23{
 public static void main(String[] args){
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter length of 1st side (in m): ");
 int a = sc.nextInt();
 System.out.println("Enter length of 2nd side (in m): ");
 int b = sc.nextInt();
 System.out.println("Enter length of 3rd side (in m): ");
 int c = sc.nextInt();
   double round = 5000/(a+b+c) ;
   System.out.println("The total number of rounds the athlete will run is "+round+" to complete 5 km");
}
}