import java.util.Scanner;
public class Q20{
 public static void main(String[] args){
 Scanner sc = new Scanner(System.in);
 int p = sc.nextInt();
 int t = sc.nextInt();
 int r = sc.nextInt();
   double SPI = (p*t*r)/100;
   System.out.println("The Simple Interest is "+SPI+" for Principal "+p+", Rate of Interest "+r+" and Time "+t);
}
}