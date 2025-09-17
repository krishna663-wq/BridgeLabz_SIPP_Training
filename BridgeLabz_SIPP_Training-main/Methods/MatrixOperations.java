public class MatrixOperations {
    public static void main(String[] args) {
        int[][] A = {{1, 2}, {3, 4}};
        int[][] B = {{5, 6}, {7, 8}};

        int[][] add = new int[2][2];
        int[][] sub = new int[2][2];
        int[][] mul = new int[2][2];

        // Addition and Subtraction
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                add[i][j] = A[i][j] + B[i][j];
                sub[i][j] = A[i][j] - B[i][j];
            }
        }

        // Multiplication
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                mul[i][j] = 0;
                for (int k = 0; k < 2; k++) {
                    mul[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        System.out.println("Addition:");
        printMatrix(add);
        System.out.println("Subtraction:");
        printMatrix(sub);
        System.out.println("Multiplication:");
        printMatrix(mul);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }
}