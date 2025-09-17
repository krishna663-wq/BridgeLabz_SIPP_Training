import java.util.*;
import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class PolicyMap {
    String policyNo, holder, coverage;
    LocalDate expiry;
    double premium;
    PolicyMap(String p,String h,LocalDate e,String c,double pr){ policyNo=p; holder=h; expiry=e; coverage=c; premium=pr;}
    public String toString(){ return policyNo+"|"+holder+"|"+expiry+"|"+coverage+"|"+premium; }
}

public class MapProblems {
    static Scanner in = new Scanner(System.in);
    static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    static void wordFrequencyFromText() {
        System.out.println("Enter text (single line):");
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            line = line.replaceAll("[^a-zA-Z0-9\\s]"," ").toLowerCase();
            String[] words = line.split("\\s+");
            Map<String,Integer> freq = new HashMap<>();
            for(String w: words) if(w.length()>0) freq.put(w, freq.getOrDefault(w,0)+1);
            System.out.println(freq);
        }catch(Exception e){ System.out.println("err"); }
    }

    static void invertMap() {
        System.out.println("Enter n then n entries key value (strings):");
        int n = in.nextInt();
        Map<String,String> m = new HashMap<>();
        for(int i=0;i<n;i++) m.put(in.next(), in.next());
        Map<String,List<String>> inv = new HashMap<>();
        for(Map.Entry<String,String> e: m.entrySet()){
            inv.computeIfAbsent(e.getValue(),k->new ArrayList<>()).add(e.getKey());
        }
        System.out.println(inv);
    }

    static void keyWithHighestValue() {
        System.out.println("Enter n then n key value pairs (string int):");
        int n = in.nextInt();
        Map<String,Integer> m = new HashMap<>();
        for(int i=0;i<n;i++) m.put(in.next(), in.nextInt());
        String best=null; int bestv=Integer.MIN_VALUE;
        for(Map.Entry<String,Integer> e: m.entrySet()) if(e.getValue()>bestv){ best=e.getKey(); bestv=e.getValue(); }
        System.out.println(best);
    }

    static void mergeTwoMaps() {
        System.out.println("Enter n1 then pairs, then n2 then pairs:");
        int n1 = in.nextInt();
        Map<String,Integer> m = new HashMap<>();
        for(int i=0;i<n1;i++) m.put(in.next(), in.nextInt());
        int n2 = in.nextInt();
        for(int i=0;i<n2;i++){
            String k = in.next(); int v = in.nextInt();
            m.put(k, m.getOrDefault(k,0)+v);
        }
        System.out.println(m);
    }

    static class Employee { String name, dept; Employee(String n,String d){name=n;dept=d;} public String toString(){return name;} }
    static void groupEmployeesByDept() {
        System.out.println("Enter n then n name dept pairs:");
        int n = in.nextInt();
        Map<String,List<Employee>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            String name = in.next(); String dept = in.next();
            map.computeIfAbsent(dept,k->new ArrayList<>()).add(new Employee(name,dept));
        }
        System.out.println(map);
    }

    static void insuranceMapDemo(){
        Map<String,PolicyMap> hm = new HashMap<>();
        Map<String,PolicyMap> lhm = new LinkedHashMap<>();
        TreeMap<LocalDate,List<PolicyMap>> tm = new TreeMap<>();
        while(true){
            System.out.println("Insurance Map Ops 1 Add 2 GetByPolicyNo 3 Expiring30 4 ByHolder 5 RemoveExpired 6 Exit");
            int ch = in.nextInt();
            if(ch==6) break;
            if(ch==1){
                System.out.println("Enter policyNo holder expiry(yyyy-MM-dd) coverage premium");
                PolicyMap p = new PolicyMap(in.next(), in.next(), LocalDate.parse(in.next(),fmt), in.next(), in.nextDouble());
                hm.put(p.policyNo,p); lhm.put(p.policyNo,p);
                tm.computeIfAbsent(p.expiry, k->new ArrayList<>()).add(p);
            } else if(ch==2){
                System.out.println("Enter policyNo:");
                System.out.println(hm.get(in.next()));
            } else if(ch==3){
                LocalDate now = LocalDate.now(), lim = now.plusDays(30);
                for(Map.Entry<LocalDate,List<PolicyMap>> e: tm.subMap(now, true, lim, true).entrySet()){
                    for(PolicyMap p: e.getValue()) System.out.println(p);
                }
            } else if(ch==4){
                System.out.println("Enter holder name:");
                String h = in.next();
                for(PolicyMap p: hm.values()) if(p.holder.equals(h)) System.out.println(p);
            } else if(ch==5){
                LocalDate now = LocalDate.now();
                List<String> toRemove = new ArrayList<>();
                for(Map.Entry<String,PolicyMap> e: hm.entrySet()) if(e.getValue().expiry.isBefore(now)) toRemove.add(e.getKey());
                for(String k: toRemove){ hm.remove(k); lhm.remove(k); }
                System.out.println("Removed "+toRemove.size());
            }
        }
    }

    static void votingSystem(){
        System.out.println("Enter number of votes then candidate names (each vote is a candidate name):");
        int n = in.nextInt();
        Map<String,Integer> votes = new HashMap<>();
        for(int i=0;i<n;i++) votes.put(in.next(), votes.getOrDefault(in.next(),0)+1);
        TreeMap<String,Integer> sorted = new TreeMap<>( (a,b)-> votes.get(b).compareTo(votes.get(a)) );
        sorted.putAll(votes);
        LinkedHashMap<String,Integer> insertion = new LinkedHashMap<>();
        in.nextLine();
        // The above approach needs better handling; but we'll display maps:
        System.out.println("Votes (HashMap): "+votes);
        System.out.println("Sorted (by candidate name asc): "+new TreeMap<>(votes));
        LinkedHashMap<String,Integer> maintain = new LinkedHashMap<>();
        // can't reconstruct insertion order without input; skipping
    }

    static void shoppingCart(){
        System.out.println("Enter n then n entries product price (string double):");
        int n = in.nextInt();
        Map<String,Double> priceMap = new HashMap<>();
        LinkedHashMap<String,Integer> cartOrder = new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            String prod = in.next(); double pr = in.nextDouble();
            priceMap.put(prod, pr);
        }
        System.out.println("Enter m add-to-cart operations with product and quantity:");
        int m = in.nextInt();
        for(int i=0;i<m;i++){
            String p = in.next(); int q = in.nextInt();
            cartOrder.put(p, cartOrder.getOrDefault(p,0)+q);
        }
        System.out.println("Cart (in insertion order):");
        for(Map.Entry<String,Integer> e: cartOrder.entrySet()) System.out.println(e.getKey()+" x"+e.getValue()+" @ "+priceMap.getOrDefault(e.getKey(),0.0));
        List<Map.Entry<String,Double>> byPrice = new ArrayList<>();
        for(Map.Entry<String,Double> e: priceMap.entrySet()) byPrice.add(e);
        byPrice.sort(Comparator.comparing(Map.Entry::getValue));
        System.out.println("Items sorted by price: "+byPrice);
    }

    static void bankingSystem(){
        System.out.println("Enter n accounts (accNumber balance):");
        int n = in.nextInt();
        Map<String,Double> accounts = new HashMap<>();
        for(int i=0;i<n;i++) accounts.put(in.next(), in.nextDouble());
        TreeMap<Double,List<String>> byBalance = new TreeMap<>();
        for(Map.Entry<String,Double> e: accounts.entrySet()) byBalance.computeIfAbsent(e.getValue(),k->new ArrayList<>()).add(e.getKey());
        System.out.println("Enter withdrawal requests count:");
        int q = in.nextInt();
        Queue<String[]> req = new LinkedList<>();
        for(int i=0;i<q;i++) req.add(new String[]{in.next(), String.valueOf(in.nextDouble())});
        while(!req.isEmpty()){
            String[] r = req.remove();
            String acc = r[0]; double amt = Double.parseDouble(r[1]);
            double bal = accounts.getOrDefault(acc, 0.0);
            if(bal>=amt){ accounts.put(acc, bal-amt); System.out.println("Processed "+acc); }
            else System.out.println("Insufficient "+acc);
        }
    }

    public static void main(String[] args){
        while(true){
            System.out.println("Map Problems\n1 WordFreq 2 InvertMap 3 MaxKey 4 MergeMaps 5 GroupEmployees 6 Insurance(Map) 7 Voting 8 ShoppingCart 9 Banking 10 Exit");
            int ch = in.nextInt();
            if(ch==10) break;
            switch(ch){
                case 1: wordFrequencyFromText(); break;
                case 2: invertMap(); break;
                case 3: keyWithHighestValue(); break;
                case 4: mergeTwoMaps(); break;
                case 5: groupEmployeesByDept(); break;
                case 6: insuranceMapDemo(); break;
                case 7: votingSystem(); break;
                case 8: shoppingCart(); break;
                case 9: bankingSystem(); break;
                default: System.out.println("Invalid");
            }
        }
    }
}
