package this_is_coding_test.dp;

public class Fibonazzi {
    private static int[] memo;

    public static void main(String[] args) {
        memo = new int[1_000_000];

        int result = fibonazzi(10);
        memo[0] = 1;
        memo[1] = 1;

        System.out.println(result);
    }

    private static int fibonazzi(int num) {
        if (num == 0 || num == 1)
            return 1;

        if (memo[num] != 0)
            return memo[num];

        int result = fibonazzi(num - 1) + fibonazzi(num - 2);
        memo[num] = result;

        return result;
    }
}
