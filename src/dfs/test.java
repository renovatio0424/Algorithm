package dfs;

import java.util.Scanner;

public class test {
    private static int[] arr = new int[20];
    private static int[] subset = new int[20];
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        makeSubset(0, 0);
    }

    private static void makeSubset(int idx, int cnt) {
        if (idx == N) {
            System.out.print("{");
            for (int i = 0; i < cnt; i++)
                System.out.print(subset[i] + ", ");
            System.out.print("}");
            return;
        }

        // arr[idx] -> subset
        subset[cnt] = arr[idx];
        makeSubset(idx + 1, cnt + 1);

        // arr[idx] x
        makeSubset(idx + 1, cnt);
    }

}
