import java.util.*;
import java.util.stream.*;

class Student {
    String name;
    String grade;
    Student(String name, String grade) {
        this.name = name;
        this.grade = grade;
    }
    public String getName() { return name; }
    public String getGrade() { return grade; }
}

public class StudentResultGrouping {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Aman", "A"),
            new Student("Riya", "B"),
            new Student("Karan", "A"),
            new Student("Tina", "C"),
            new Student("Mohan", "B")
        );

        Map<String, List<String>> grouped = students.stream()
            .collect(Collectors.groupingBy(Student::getGrade,
                     Collectors.mapping(Student::getName, Collectors.toList())));

        System.out.println(grouped);
    }
}
