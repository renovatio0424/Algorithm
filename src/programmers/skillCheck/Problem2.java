package programmers.skillCheck;

import java.util.Arrays;

public class Problem2 {
    public static void main(String[] args) {
        int n = 3;
        int m = 12;

        int[] result = solution(n, m);

        System.out.println("result: " + Arrays.toString(result));
    }

    private static int[] solution(int n, int m) {
        int[] result = new int[2];

        int gcm = gcd(n, m);
        int lcm = lcm(n, m, gcm);

        result[0] = gcm;
        result[1] = lcm;

        return result;
    }

    private static int lcm(int n, int m, int gcm) {
        return n * m / gcm;
    }

    private static int gcd(int a, int b) {
        if (a % b == 0)
            return b;

        int r = a % b;

        return gcd(b, r);
    }


}
