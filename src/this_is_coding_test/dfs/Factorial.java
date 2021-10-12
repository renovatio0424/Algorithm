package this_is_coding_test.dfs;

public class Factorial {
    public static void main(String[] args) {
        int n = 4;

        int result = factorial(n);

        //4 * 3 * 2 * 1
        System.out.println(result);
    }

    private static int factorial(int n) {
        if (n <= 1)
            return 1;

        return n * factorial(n - 1);
    }
}
