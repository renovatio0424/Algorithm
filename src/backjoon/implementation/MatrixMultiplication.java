package backjoon.implementation;

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] A = getMatrix(scanner);
        int[][] B = getMatrix(scanner);

        int[][] C = multiply(A, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < C.length; i++) {
            if (i != 0)
                sb.append("\n");

            for (int j = 0; j < C[i].length; j++) {
                sb.append(C[i][j]);
                if (j != C[i].length - 1) {
                    sb.append(" ");
                }
            }
        }
        System.out.println(sb.toString());
    }

    private static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < b[0].length; k++) {
                for (int j = 0; j < a[0].length; j++) {
                    result[i][k] += a[i][j] * b[j][k];
                }
            }
        }

        return result;
    }

    private static int[][] getMatrix(Scanner scanner) {
        String input = scanner.nextLine();
        String[] inputArr = input.split(" ");

        int N = Integer.parseInt(inputArr[0]);
        int M = Integer.parseInt(inputArr[1]);

        int[][] A = new int[N][M];
        for (int i = 0; i < N; i++) {
            String inputMatrix = scanner.nextLine();
            String[] inputMatrixArr = inputMatrix.split(" ");
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(inputMatrixArr[j]);
            }
        }

        return A;
    }
}
