package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(bufferedReader.readLine());

        long result = getMaximumSumOfNumber(s, 1, 1);

        System.out.println(result);
    }

    private static long getMaximumSumOfNumber(long sum, long current, int n) {
        if (sum < current) {
            return n - 1;
        } else if (sum == current)
            return n;

        return getMaximumSumOfNumber(sum, current + n + 1, n + 1);
    }
}
