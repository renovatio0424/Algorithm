package backjoon.greedy;

import java.util.Scanner;

public class GasStation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] tollArr = new long[N - 1];
        for (int i = 0; i < N - 1; i++) {
            tollArr[i] = scanner.nextInt();
        }

        long[] gasFeeArr = new long[N];
        for (int i = 0; i < N; i++) {
            gasFeeArr[i] = scanner.nextInt();
        }

        long result = getMinimumFee(tollArr, gasFeeArr);

        System.out.println(result);
    }

    private static long getMinimumFee(long[] tollArr, long[] gasFeeArr) {
        long totalFee = 0;
        long currentFee = Long.MAX_VALUE;

        for (int i = 0; i < tollArr.length; i++) {
            currentFee = Math.min(currentFee, gasFeeArr[i]);
            totalFee += currentFee * tollArr[i];
        }
        return totalFee;
    }
}
