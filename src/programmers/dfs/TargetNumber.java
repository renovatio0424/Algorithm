package programmers.dfs;

public class TargetNumber {
    public static void main(String[] args) {
        int target = 3;
        int[] numbers = {1, 1, 1, 1, 1};
        int result = solution(numbers, target);
        System.out.println("result: " + result);
    }

    public static int count = 0;

    private static int solution(int[] numbers, int target) {
        sumTarget(numbers, 0, 0, target);
        return count;
    }

    private static void sumTarget(int[] numbers, int idx, int sum, int target) {
        if (idx == numbers.length && sum == target) {
            count += 1;
            return;
        }

        if (idx >= numbers.length) return;

        sumTarget(numbers, idx + 1, sum + numbers[idx], target);
        sumTarget(numbers, idx + 1, sum - numbers[idx], target);
    }

}
