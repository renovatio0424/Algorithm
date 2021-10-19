package this_is_coding_test.sort;

import java.util.Arrays;
import java.util.Scanner;

public class ReplaceTwoArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();

        int[][] twoArr = new int[2][N];

        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < N; i++) {
                twoArr[j][i] = scanner.nextInt();
            }
        }

        int result = getMaximum(twoArr, K);

        System.out.println(result);
    }

    private static int getMaximum(int[][] twoArr, int k) {
        int[] firstArr = twoArr[0];
        int[] secondArr = twoArr[1];

        Arrays.sort(firstArr);
        Arrays.sort(secondArr);

        for (int i = 0; i < k; i++) {
            firstArr[i] = secondArr[secondArr.length - 1 - i];
        }

        int sum = 0;

        for (int i = 0; i < firstArr.length; i++) {
            sum += firstArr[i];
        }

        return sum;
    }
}
