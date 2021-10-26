package this_is_coding_test.dp;

public class AntWarrior {
    private static int[] memo;

    public static void main(String[] args) {
        int n = 8;
        int[] foodArr = new int[]{5, 6, 9, 10, 8, 5, 2, 1};
        memo = new int[n];

        int result = 0;

        for (int i = 0; i < foodArr.length; i++) {
            result = Math.max(result, getMaxFood(foodArr, i));
        }

        System.out.println(result);
    }

    private static int getMaxFood(int[] foodArr, int start) {
        if (start > foodArr.length - 1)
            return 0;

        if (memo[start] != 0)
            return memo[start];

        int sum = foodArr[start];

        int max = 0;
        for (int i = start; i < foodArr.length; i++) {
            max = Math.max(sum, getMaxFood(foodArr, i + 2));
        }

        memo[start] = sum + max;
        return memo[start];
    }
}
