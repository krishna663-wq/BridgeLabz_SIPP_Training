import java.util.*;

public class ListProblems {
    static Scanner in = new Scanner(System.in);

    static void reverseArrayList() {
        System.out.println("Enter n and n integers for ArrayList:");
        int n = in.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++) a.add(in.nextInt());
        int l=0, r=a.size()-1;
        while(l<r){
            int tmp = a.get(l);
            a.set(l, a.get(r));
            a.set(r, tmp);
            l++; r--;
        }
        System.out.println(a);
    }

    static void reverseLinkedList() {
        System.out.println("Enter n and n integers for LinkedList:");
        int n = in.nextInt();
        LinkedList<Integer> l = new LinkedList<>();
        for(int i=0;i<n;i++) l.add(in.nextInt());
        LinkedList<Integer> res = new LinkedList<>();
        for(Integer x : l) res.addFirst(x);
        System.out.println(res);
    }

    static void frequencyOfElements() {
        System.out.println("Enter n and n strings:");
        int n = in.nextInt();
        Map<String,Integer> freq = new LinkedHashMap<>();
        for(int i=0;i<n;i++){
            String s = in.next();
            freq.put(s, freq.getOrDefault(s,0)+1);
        }
        System.out.println(freq);
    }

    static void rotateList() {
        System.out.println("Enter n, n integers, then rotateBy:");
        int n = in.nextInt();
        List<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++) a.add(in.nextInt());
        int k = in.nextInt();
        k = ((k % n) + n) % n;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++) res.add(a.get((i+k)%n));
        System.out.println(res);
    }

    static void removeDuplicatesPreserveOrder() {
        System.out.println("Enter n and n integers:");
        int n = in.nextInt();
        List<Integer> a = new ArrayList<>();
        for(int i=0;i<n;i++) a.add(in.nextInt());
        Set<Integer> seen = new LinkedHashSet<>();
        List<Integer> res = new ArrayList<>();
        for(Integer x : a){
            if(!seen.contains(x)){
                seen.add(x);
                res.add(x);
            }
        }
        System.out.println(res);
    }

    static void nthFromEndLinkedList() {
        System.out.println("Enter n and n strings (LinkedList), then N (nth from end):");
        int n = in.nextInt();
        LinkedList<String> l = new LinkedList<>();
        for(int i=0;i<n;i++) l.add(in.next());
        int N = in.nextInt();
        Iterator<String> it1 = l.iterator();
        Iterator<String> it2 = l.iterator();
        for(int i=0;i<N;i++){
            if(it2.hasNext()) it2.next();
            else { System.out.println("N is larger than size"); return; }
        }
        while(it2.hasNext()){
            it2.next(); it1.next();
        }
        System.out.println(it1.next());
    }

    public static void main(String[] args){
        while(true){
            System.out.println("List Problems\n1 Reverse ArrayList 2 Reverse LinkedList 3 Frequency 4 Rotate 5 Remove Dups 6 Nth From End 7 Exit");
            int ch = in.nextInt();
            if(ch==7) break;
            switch(ch){
                case 1: reverseArrayList(); break;
                case 2: reverseLinkedList(); break;
                case 3: frequencyOfElements(); break;
                case 4: rotateList(); break;
                case 5: removeDuplicatesPreserveOrder(); break;
                case 6: nthFromEndLinkedList(); break;
                default: System.out.println("Invalid");
            }
        }
    }
}
