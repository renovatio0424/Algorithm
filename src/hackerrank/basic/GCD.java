package hackerrank.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * 최대 공약수 (GCD) & 최대 공배수 (LCM)
 * https://twpower.github.io/69-how-to-get-gcd-and-lcm
 */
public class GCD {
    public static void main(String[] args) {
        int a = 2;
        int b = 4;
        int gcd = getGCD(16, 32);
        int lcm = getLCM(16, 32);
        System.out.println(gcd);
        System.out.println(lcm);

        List listA = new ArrayList();
        listA.sort(null);
    }

    private static int getLCM(int a, int b) {
        return a * b / getGCD(a, b);
    }

    private static int getGCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }
}
