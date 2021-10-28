package backjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Plus123 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine());
        int[] resultArr = new int[t];
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int result = countPlus123(n);
            resultArr[i] = result;
        }

        for (int result : resultArr) {
            System.out.println(result);
        }
    }

    private static int countPlus123(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        memo[2] = 2;

        return plus123(memo, 3, n);
    }

    private static int plus123(int[] memo, int start, int target) {
        if (memo[target] != 0)
            return memo[target];

        int num1 = memo[target - 1];
        int num2 = memo[target - 2];
        int num3 = memo[target - 3];

        if (memo[target - 1] == 0)
            num1 = plus123(memo, start, target - 1);

        if (memo[target - 2] == 0)
            num2 = plus123(memo, start, target - 2);

        if (memo[target - 3] == 0)
            num3 = plus123(memo, start, target - 3);

        return num1 + num2 + num3;
    }
}
