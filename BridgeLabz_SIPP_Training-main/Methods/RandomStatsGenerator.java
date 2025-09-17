import java.util.Arrays;

public class RandomStatsGenerator {
    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1000 + (int)(Math.random() * 9000);
        }
        return arr;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0], max = numbers[0], sum = 0;
        for (int num : numbers) {
            sum += num;
            if (num < min) min = num;
            if (num > max) max = num;
        }
        double avg = (double) sum / numbers.length;
        return new double[]{avg, min, max};
    }

    public static void main(String[] args) {
        int[] nums = generate4DigitRandomArray(5);
        System.out.println("Generated Numbers: " + Arrays.toString(nums));
        double[] result = findAverageMinMax(nums);
        System.out.printf("Average: %.2f, Min: %.0f, Max: %.0f%n", result[0], result[1], result[2]);
    }
}