package backjoon.greedy;

import java.util.Scanner;

public class Coin0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArr = input.split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int K = Integer.parseInt(inputArr[1]);

        int[] coinArr = new int[N];
        for (int i = 0; i < N; i++) {
            coinArr[i] = scanner.nextInt();
        }

        int result = getMinimumCoinCount(coinArr, K);

        System.out.println(result);
    }

    private static int getMinimumCoinCount(int[] coinArr, int k) {
        int count = 0;
        int remain = k;

        for (int i = coinArr.length - 1; i >= 0; i--) {
            int a = remain / coinArr[i];
            if (a > 0) {
                remain %= coinArr[i];
                count += a;
            }
        }
        return count;
    }
}
