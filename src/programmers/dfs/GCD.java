package programmers.dfs;

public class GCD {
    public static void main(String[] args) {
        int a = 192;
        int b = 162;

        int result = gcd(a, b);

        System.out.println("result: " + result);
    }

    private static int gcd(int a, int b) {
        if (a % b == 0)
            return b;

        int r = a % b;

        return gcd(b, r);
    }
}
