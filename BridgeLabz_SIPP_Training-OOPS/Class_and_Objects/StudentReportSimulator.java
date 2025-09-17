public class StudentReportSimulator {
    String name;
    int rollNumber;
    int marks;

    // Constructor to initialize student attributes
    public StudentReportSimulator(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to calculate grade based on marks
    public String calculateGrade() {
        if (marks >= 90) return "A";
        else if (marks >= 75) return "B";
        else if (marks >= 60) return "C";
        else if (marks >= 50) return "D";
        else return "F";
    }

    // Method to display student details and grade
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }

    // Main method to test the class
    public static void main(String[] args) {
        StudentReportSimulator student = new StudentReportSimulator("Alice", 101, 82);
        student.displayDetails();
    }
}