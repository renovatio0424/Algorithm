package dfs;

import java.util.Scanner;

public class DfsSolution4 {

    public static int count = 0;
    public static int S;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        S = scanner.nextInt();

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }

        for (int j = 0; j < arr.length; j++)
            countSumEqualS(arr[j], j + 1);

        System.out.println(count + "");
    }

    private static void countSumEqualS(int sum, int startIndex) {
        if (S == sum) {
            count++;
            return;
        }

        if (arr.length - 1 == startIndex)
            return;

        for (int i = startIndex; i < arr.length; i++) {
            countSumEqualS(sum + arr[i], i + 1);
        }
    }
}
