import java.util.Scanner;
public class Q21{
 public static void main(String[] args){
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter Name: ");
 String name = sc.nextLine();
 System.out.println("Enter fromCity: ");
 String fromCity = sc.nextLine();
 System.out.println("Enter viaCity: ");
 String viaCity = sc.nextLine();
 System.out.println("Enter toCity: ");
 String toCity = sc.nextLine();
 System.out.println("Enter distance from fromCity to viaCity (in miles): ");
 int dist1  = sc.nextInt();
 System.out.println("Enter distance from viaCity to FinalCity (in miles): ");
 int dist2  = sc.nextInt();
 double netdist = (dist1 + dist2) / 1.6;
 System.out.println("Enter time taken from fromCity to viaCity (in mins): ");
 int time1  = sc.nextInt();
 System.out.println("Enter time taken from viaCity to FinalCity (in mins): ");
 int time2  = sc.nextInt();
 int nettime = time1+time2;
   System.out.println("The Total Distance travelled by "+name+" from "+fromCity+" to "+toCity+" via "+viaCity+" is "+netdist+" km and the Total Time taken is "+nettime+" minutes.");
}
}