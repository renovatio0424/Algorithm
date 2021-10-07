package backjoon.implementation;

import java.util.Scanner;

public class SuperMario {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] scoreArr = new int[10];

        for (int i = 0; i < 10; i++) {
            scoreArr[i] = scanner.nextInt();
        }

        int result = getAlmostTotalPoint(scoreArr, 100);

        System.out.println(result);
    }

    private static int getAlmostTotalPoint(int[] scoreArr, int expectPoint) {
        int[] diffArr = new int[scoreArr.length];
        int sum = 0;

        for (int i = 0; i < scoreArr.length; i++) {
            sum += scoreArr[i];
            diffArr[i] = 100 - sum;
        }

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < diffArr.length; i ++) {
            int a = Math.abs(minDiff);
            int b = Math.abs(diffArr[i]);

            if (a >= b)
                minDiff = diffArr[i];
        }

        return 100 - minDiff;
    }
}
