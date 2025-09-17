import java.util.*;

abstract class JobRole {
    String roleName;
    JobRole(String roleName){ this.roleName = roleName; }
    public String toString(){ return roleName; }
}

class SoftwareEngineer extends JobRole {
    SoftwareEngineer(){ super("SoftwareEngineer"); }
}

class DataScientist extends JobRole {
    DataScientist(){ super("DataScientist"); }
}

class ProductManager extends JobRole {
    ProductManager(){ super("ProductManager"); }
}

class Resume<T extends JobRole> {
    String id;
    String candidate;
    T role;
    double score;
    Resume(String id,String candidate,T role,double score){ this.id=id; this.candidate=candidate; this.role=role; this.score=score; }
    public String toString(){ return id + " " + candidate + " for " + role + " score:" + score; }
}

public class ResumeScreeningSystem {
    static List<Resume<? extends JobRole>> filterByScore(List<Resume<? extends JobRole>> list, double minScore){
        List<Resume<? extends JobRole>> out = new ArrayList<>();
        for(Resume<? extends JobRole> r : list) if(r.score >= minScore) out.add(r);
        return out;
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<Resume<? extends JobRole>> pool = new ArrayList<>();
        System.out.println("How many resumes to input?");
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter id");
            String id = in.next();
            System.out.println("Enter candidate name");
            String name = in.next();
            System.out.println("Choose role 1 SE 2 DS 3 PM");
            int t = in.nextInt();
            System.out.println("Enter score (0-100)");
            double s = in.nextDouble();
            if(t==1) pool.add(new Resume<>(id,name,new SoftwareEngineer(),s));
            else if(t==2) pool.add(new Resume<>(id,name,new DataScientist(),s));
            else pool.add(new Resume<>(id,name,new ProductManager(),s));
        }
        System.out.println("Enter minimum score to shortlist");
        double min = in.nextDouble();
        List<Resume<? extends JobRole>> shortlisted = filterByScore(pool,min);
        System.out.println("Shortlisted:");
        for(Resume<? extends JobRole> r : shortlisted) System.out.println(r);
    }
}
