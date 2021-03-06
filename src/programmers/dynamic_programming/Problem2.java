package programmers.dynamic_programming;

public class Problem2 {
    public static void main(String[] args) {
        int[][] triangleArr = {{7}};//{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        int result = solution(triangleArr);
        System.out.println("result : " + result);
    }

    private static int answer = 0;

    private static int solution(int[][] triangleArr) {
        answer = triangleArr[0][0];
        dfs(triangleArr, 0, triangleArr[0][0]);
        return answer;
    }

    private static void dfs(int[][] triangleArr, int startIdx, int prevSum) {
        if (startIdx + 1 >= triangleArr.length - 1)
            return;

        int[] row = triangleArr[startIdx + 1];

        for (int i = 0; i < row.length; i++) {
            int tmpSum = row[i] + prevSum;
            answer = Math.max(tmpSum, answer);
            dfs(triangleArr, startIdx + 1, tmpSum);
        }
    }
}
