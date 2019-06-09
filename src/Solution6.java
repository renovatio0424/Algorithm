import java.util.Scanner;

public class Solution6 {
    public static int[][] resultMatrix;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixLength = scanner.nextInt();
        double matrixPowerCount = scanner.nextDouble();

        int[][] matrix = new int[matrixLength][matrixLength];

        for (int i = 0; i < matrixLength; i++) {
            for (int j = 0; j < matrixLength; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        resultMatrix = new int[matrixLength][matrixLength];

        powerMatrix(matrix, matrix, matrixPowerCount);

        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                System.out.print(resultMatrix[i][j]);

                if (j != resultMatrix[i].length - 1)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static int[][] powerMatrix(int[][] matrixA, int[][] matrixB, double n) {
        if (n <= 1)
            return matrixA;
        else {

            for (int i = 0; i < matrixA.length; i++) {
                for (int j = 0; j < matrixA.length; j++) {
                    int sum = 0;
                    for (int k = 0; k < matrixA[i].length; k++)
                        sum += matrixA[i][k] * matrixB[k][j];

                    resultMatrix[i][j] = sum % 1000;
                }
            }

            return powerMatrix(resultMatrix, matrixB, n - 1);
        }
    }
}
