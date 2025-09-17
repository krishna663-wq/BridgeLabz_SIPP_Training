import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

class Policy implements Comparable<Policy>{
    String policyNo;
    String holder;
    LocalDate expiry;
    String coverage;
    double premium;
    Policy(String p,String h,LocalDate e,String c,double pr){ policyNo=p; holder=h; expiry=e; coverage=c; premium=pr;}
    public String toString(){ return policyNo+"|"+holder+"|"+expiry+"|"+coverage+"|"+premium; }
    public int compareTo(Policy o){ return this.expiry.compareTo(o.expiry); }
    public boolean equals(Object o){
        if(!(o instanceof Policy)) return false;
        return ((Policy)o).policyNo.equals(this.policyNo);
    }
    public int hashCode(){ return Objects.hash(policyNo); }
}

public class SetProblems {
    static Scanner in = new Scanner(System.in);
    static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    static Policy readPolicy(){
        System.out.println("Enter policyNo holder expiry(yyyy-MM-dd) coverage premium");
        String p = in.next();
        String h = in.next();
        LocalDate e = LocalDate.parse(in.next(), fmt);
        String c = in.next();
        double pr = in.nextDouble();
        return new Policy(p,h,e,c,pr);
    }

    static void basicSetOps(){
        System.out.println("Enter size and elements for Set1 (ints) then Set2:");
        int n1 = in.nextInt();
        Set<Integer> s1 = new HashSet<>();
        for(int i=0;i<n1;i++) s1.add(in.nextInt());
        int n2 = in.nextInt();
        Set<Integer> s2 = new HashSet<>();
        for(int i=0;i<n2;i++) s2.add(in.nextInt());
        System.out.println("Equal: " + s1.equals(s2));
        Set<Integer> union = new HashSet<>(s1);
        union.addAll(s2);
        Set<Integer> inter = new HashSet<>(s1);
        inter.retainAll(s2);
        Set<Integer> sym = new HashSet<>(union);
        sym.removeAll(inter);
        List<Integer> sorted = new ArrayList<>(new HashSet<>(s1));
        Collections.sort(sorted);
        System.out.println("Union: "+union);
        System.out.println("Intersection: "+inter);
        System.out.println("Symmetric: "+sym);
        System.out.println("Sorted from Set1: "+sorted);
        System.out.println("Subset? enter candidate set size then elements:");
        int m = in.nextInt();
        Set<Integer> cand = new HashSet<>();
        for(int i=0;i<m;i++) cand.add(in.nextInt());
        System.out.println("Is candidate subset of Set2? " + s2.containsAll(cand));
    }

    static void insuranceWithSets(){
        System.out.println("Insurance with sets demo. You can add policies to HashSet, LinkedHashSet, TreeSet (by expiry).");
        Set<Policy> hs = new HashSet<>();
        Set<Policy> lhs = new LinkedHashSet<>();
        Set<Policy> ts = new TreeSet<>();
        while(true){
            System.out.println("1 Add 2 ShowAll 3 ExpiringWithin30 4 ByCoverage 5 DuplicatesByPolicyNo 6 PerfCompare 7 Exit");
            int ch = in.nextInt();
            if(ch==7) break;
            if(ch==1){
                Policy p = readPolicy();
                hs.add(p); lhs.add(p); ts.add(p);
                System.out.println("Added");
            } else if(ch==2){
                System.out.println("HashSet:");
                for(Policy p:hs) System.out.println(p);
                System.out.println("LinkedHashSet:");
                for(Policy p:lhs) System.out.println(p);
                System.out.println("TreeSet(sorted by expiry):");
                for(Policy p:ts) System.out.println(p);
            } else if(ch==3){
                LocalDate now = LocalDate.now();
                LocalDate limit = now.plusDays(30);
                System.out.println("Expiring within 30 days:");
                for(Policy p:ts) if(!p.expiry.isBefore(now) && !p.expiry.isAfter(limit)) System.out.println(p);
            } else if(ch==4){
                System.out.println("Enter coverage type:");
                String cov = in.next();
                for(Policy p:hs) if(p.coverage.equalsIgnoreCase(cov)) System.out.println(p);
            } else if(ch==5){
                Map<String,List<Policy>> map = new HashMap<>();
                for(Policy p:hs) map.computeIfAbsent(p.policyNo,k->new ArrayList<>()).add(p);
                for(Map.Entry<String,List<Policy>> e: map.entrySet()) if(e.getValue().size()>1) System.out.println("Dup: "+e.getKey()+" -> "+e.getValue());
            } else if(ch==6){
                int trials = 10000;
                Policy sample = new Policy("P"+System.currentTimeMillis(),"X",LocalDate.now().plusDays(10),"H",1000);
                long t1 = System.nanoTime();
                for(int i=0;i<trials;i++) hs.add(new Policy(sample.policyNo+i,"A",sample.expiry,sample.coverage,100));
                long t2 = System.nanoTime();
                for(int i=0;i<trials;i++) lhs.add(new Policy(sample.policyNo+i,"A",sample.expiry,sample.coverage,100));
                long t3 = System.nanoTime();
                for(int i=0;i<trials;i++) ts.add(new Policy(sample.policyNo+i,"A",sample.expiry.plusDays(i%365),sample.coverage,100));
                long t4 = System.nanoTime();
                System.out.println("Add times (ns): HashSet "+(t2-t1)+" LinkedHashSet "+(t3-t2)+" TreeSet "+(t4-t3));
            }
        }
    }

    public static void main(String[] args){
        while(true){
            System.out.println("Set Problems\n1 Basic Set Ops 2 Insurance (Sets) 3 Exit");
            int ch = in.nextInt();
            if(ch==3) break;
            if(ch==1) basicSetOps();
            else if(ch==2) insuranceWithSets();
            else System.out.println("Invalid");
        }
    }
}
