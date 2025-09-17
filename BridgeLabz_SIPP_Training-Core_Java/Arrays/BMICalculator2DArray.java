import java.util.Scanner;

public class BMICalculator2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Person " + (i + 1) + ":");

            System.out.print("Weight (kg): ");
            double weight = sc.nextDouble();
            if (weight <= 0) {
                System.out.println("Invalid weight. Please re-enter this person's data.");
                i--;
                continue;
            }

            System.out.print("Height (m): ");
            double height = sc.nextDouble();
            if (height <= 0) {
                System.out.println("Invalid height. Please re-enter this person's data.");
                i--;
                continue;
            }

            double bmi = weight / (height * height);

            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = bmi;

            weightStatus[i] = getBMIStatus(bmi);
        }

        System.out.println("\nBMI Report:");
        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d - Weight: %.2f kg, Height: %.2f m, BMI: %.2f, Status: %s\n",
                    i + 1, personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }

    public static String getBMIStatus(double bmi) {
        if (bmi <= 18.4)
            return "Underweight";
        else if (bmi <= 24.9)
            return "Normal";
        else if (bmi <= 39.9)
            return "Overweight";
        else
            return "Obese";
    }
}
