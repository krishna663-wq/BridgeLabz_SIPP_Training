import java.util.*;

abstract class CourseType {
    String details;
    CourseType(String details){ this.details = details; }
    public String toString(){ return this.getClass().getSimpleName() + "(" + details + ")"; }
}

class ExamCourse extends CourseType {
    ExamCourse(String d){ super(d); }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String d){ super(d); }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String d){ super(d); }
}

class Course<T extends CourseType> {
    String code;
    String title;
    int credits;
    T type;
    Course(String code, String title, int credits, T type){
        this.code = code; this.title = title; this.credits = credits; this.type = type;
    }
    public String toString(){ return code + " " + title + " " + credits + "cr " + type; }
}

public class UniversityCourseSystem {
    static void printCourses(List<Course<? extends CourseType>> list){
        if(list.isEmpty()) System.out.println("No courses");
        for(Course<? extends CourseType> c : list) System.out.println(c);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        List<Course<? extends CourseType>> all = new ArrayList<>();
        System.out.println("How many courses to add?");
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("Enter code");
            String code = in.next();
            System.out.println("Enter title");
            String title = in.next();
            System.out.println("Enter credits");
            int credits = in.nextInt();
            System.out.println("Choose type 1 Exam 2 Assignment 3 Research");
            int t = in.nextInt();
            System.out.println("Enter detail note");
            String d = in.next();
            if(t==1) all.add(new Course<>(code,title,credits,new ExamCourse(d)));
            else if(t==2) all.add(new Course<>(code,title,credits,new AssignmentCourse(d)));
            else all.add(new Course<>(code,title,credits,new ResearchCourse(d)));
        }
        System.out.println("All Courses:");
        printCourses(all);
    }
}
