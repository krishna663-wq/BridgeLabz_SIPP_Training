import java.util.*;

public class QueueProblems {
    static Scanner in = new Scanner(System.in);

    static void reverseQueue() {
        System.out.println("Enter n and n integers for queue:");
        int n = in.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) q.add(in.nextInt());
        Stack<Integer> st = new Stack<>();
        while(!q.isEmpty()) st.push(q.remove());
        while(!st.isEmpty()) q.add(st.pop());
        System.out.println(q);
    }

    static void generateBinaryNumbers() {
        System.out.println("Enter N:");
        int N = in.nextInt();
        Queue<String> q = new LinkedList<>();
        List<String> out = new ArrayList<>();
        q.add("1");
        for(int i=0;i<N;i++){
            String s = q.remove();
            out.add(s);
            q.add(s+"0"); q.add(s+"1");
        }
        System.out.println(out);
    }

    static void hospitalTriage() {
        System.out.println("Enter number of patients then name severity (higher is more severe):");
        int n = in.nextInt();
        PriorityQueue<String> pq = new PriorityQueue<>( (a,b)->{
            String[] pa = a.split("#"); String[] pb = b.split("#");
            int sa = Integer.parseInt(pa[1]); int sb = Integer.parseInt(pb[1]);
            return Integer.compare(sb,sa);
        });
        for(int i=0;i<n;i++){
            String name = in.next(); int sev = in.nextInt();
            pq.add(name+"#"+sev);
        }
        System.out.println("Order:");
        while(!pq.isEmpty()){
            String s = pq.remove();
            System.out.println(s.split("#")[0]);
        }
    }

    static class StackUsingQueues {
        Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        void push(int x){ q1.add(x); }
        int pop(){
            if(q1.isEmpty()) return Integer.MIN_VALUE;
            while(q1.size()>1) q2.add(q1.remove());
            int val = q1.remove();
            Queue<Integer> tmp = q1; q1 = q2; q2 = tmp;
            return val;
        }
        int top(){
            if(q1.isEmpty()) return Integer.MIN_VALUE;
            while(q1.size()>1) q2.add(q1.remove());
            int val = q1.remove();
            q2.add(val);
            Queue<Integer> tmp = q1; q1 = q2; q2 = tmp;
            return val;
        }
    }

    static void stackUsingQueuesDemo(){
        System.out.println("Operations: 1 push 2 pop 3 top 4 exit");
        StackUsingQueues s = new StackUsingQueues();
        while(true){
            int op = in.nextInt();
            if(op==4) break;
            if(op==1) s.push(in.nextInt());
            else if(op==2) System.out.println(s.pop());
            else if(op==3) System.out.println(s.top());
        }
    }

    static class CircularBuffer {
        int[] buf; int cap; int head=0; int count=0;
        CircularBuffer(int c){ cap=c; buf=new int[c]; }
        void insert(int x){
            int tail = (head + count) % cap;
            if(count==cap){
                head = (head+1)%cap;
                buf[tail]=x;
            } else {
                buf[tail]=x; count++;
            }
        }
        List<Integer> snapshot(){
            List<Integer> out = new ArrayList<>();
            for(int i=0;i<count;i++) out.add(buf[(head+i)%cap]);
            return out;
        }
    }

    static void circularBufferDemo(){
        System.out.println("Enter buffer size:");
        int c = in.nextInt();
        CircularBuffer cb = new CircularBuffer(c);
        System.out.println("Enter operations: insert x as '1 x', show as '2', exit '3'");
        while(true){
            int op = in.nextInt();
            if(op==3) break;
            if(op==1) cb.insert(in.nextInt());
            else if(op==2) System.out.println(cb.snapshot());
        }
    }

    public static void main(String[] args){
        while(true){
            System.out.println("Queue Problems\n1 Reverse Queue 2 Binary Numbers 3 Triage 4 Stack using Queues 5 Circular Buffer 6 Exit");
            int ch = in.nextInt();
            if(ch==6) break;
            switch(ch){
                case 1: reverseQueue(); break;
                case 2: generateBinaryNumbers(); break;
                case 3: hospitalTriage(); break;
                case 4: stackUsingQueuesDemo(); break;
                case 5: circularBufferDemo(); break;
                default: System.out.println("Invalid");
            }
        }
    }
}
