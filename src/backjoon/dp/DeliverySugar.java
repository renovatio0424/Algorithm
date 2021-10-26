package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DeliverySugar {
    private static int[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        deliverySugar(n, 0);

        System.out.println(memo[0]);
    }

    private static void deliverySugar(int n, int count) {
        if (n < 0)
            return;

        if (n == 0) {
            if (memo[n] == -1){
                memo[n] = count;
                return;
            }

            memo[n] = Math.min(memo[n], count);
            return;
        }

        if (memo[n] == -1)
            memo[n] = count;
        else
            return;

        deliverySugar(n - 5, count + 1);
        deliverySugar(n - 3, count + 1);
    }
}
