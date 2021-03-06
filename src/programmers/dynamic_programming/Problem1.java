package programmers.dynamic_programming;

public class Problem1 {
    private static int n;
    private static int target;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int N = 5;
        int number = 12;
        int result = solution(N, number);
        System.out.println("result : " + result);
    }

    public static int solution(int N, int number) {
        n = N;
        target = number;
        dfs(0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private static void dfs(int count, int prev) {
        if (count > 8) {
            answer = -1;
            return;
        }

        if (prev == target) {
            answer = Math.min(answer, count);
            return;
        }

        int tempN = n;
        for (int i = 0; i < 8 - count; i++) {
            int newCount = count + i + 1;
            dfs(newCount, prev + tempN);
            dfs(newCount, prev - tempN);
            dfs(newCount, tempN - prev);
            dfs(newCount, prev / tempN);
            if (prev != 0) dfs(newCount, tempN / prev);
            dfs(newCount, prev * tempN);

            tempN = tempN * 10 + n;
        }
    }
}
