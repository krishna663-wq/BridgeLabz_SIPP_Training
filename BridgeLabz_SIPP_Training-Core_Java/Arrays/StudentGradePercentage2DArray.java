import java.util.Scanner;

public class StudentGradePercentage2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");

            for (int j = 0; j < 3; j++) {
                String subject = j == 0 ? "Physics" : j == 1 ? "Chemistry" : "Maths";
                System.out.print(subject + ": ");
                marks[i][j] = sc.nextInt();

                if (marks[i][j] < 0) {
                    System.out.println("Invalid marks, please re-enter all marks for this student.");
                    i--;
                    break;
                }
            }

            if (marks[i][0] >= 0 && marks[i][1] >= 0 && marks[i][2] >= 0) {
                int total = marks[i][0] + marks[i][1] + marks[i][2];
                percentage[i] = total / 3.0;
                grade[i] = getGrade(percentage[i]);
            }
        }

        System.out.println("\nStudent Results:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + ": Physics = " + marks[i][0] + ", Chemistry = " + marks[i][1]
                    + ", Maths = " + marks[i][2]);
            System.out.println("Percentage: " + String.format("%.3f", percentage[i]) + "%, Grade: " + grade[i]);
            System.out.println("-----------------------");
        }
    }

    public static char getGrade(double percent) {
        if (percent >= 80)
            return 'A';
        else if (percent >= 70)
            return 'B';
        else if (percent >= 60)
            return 'C';
        else if (percent >= 50)
            return 'D';
        else if (percent >= 40)
            return 'E';
        else
            return 'R';
    }
}
