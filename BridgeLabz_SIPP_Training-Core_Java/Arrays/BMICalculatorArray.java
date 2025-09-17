import java.util.Scanner;

public class BMICalculatorArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[] weight = new double[number];
        double[] height = new double[number];
        double[] bmi = new double[number];
        String[] status = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("Enter details for Person " + (i + 1) + ":");

            System.out.print("Weight (kg): ");
            weight[i] = sc.nextDouble();
            if (weight[i] <= 0) {
                System.out.println("Invalid weight. Please re-enter this person's data.");
                i--;
                continue;
            }

            System.out.print("Height (m): ");
            height[i] = sc.nextDouble();
            if (height[i] <= 0) {
                System.out.println("Invalid height. Please re-enter this person's data.");
                i--;
                continue;
            }

            bmi[i] = weight[i] / (height[i] * height[i]);
            status[i] = getBMIStatus(bmi[i]);
        }

        System.out.println("\nBMI Report:");
        for (int i = 0; i < number; i++) {
            System.out.printf("Person %d - Weight: %.2f kg, Height: %.2f m, BMI: %.2f, Status: %s\n",
                    i + 1, weight[i], height[i], bmi[i], status[i]);
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
