package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonazzi4 {
    private static int[] memo = new int[21];

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        memo[0] = 0;
        memo[1] = 1;

        int result = fibonazzi(n);

        System.out.println(result);
    }

    private static int fibonazzi(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;

        if (memo[n] != 0)
            return memo[n];

        int m = fibonazzi(n-1) + fibonazzi(n-2);
        memo[n] = m;

        return memo[n];
    }
}
