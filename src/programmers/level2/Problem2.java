package programmers.level2;

import java.util.Arrays;

public class Problem2 {
    public static void main(String[] args) {
        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int K = 7;

        int result = solution(scoville, K);

        System.out.println(result);
    }

    private static int solution(int[] scoville, int K) {
        int count = 0;
        int currentIdx = 0;

        while (!isValid(scoville, K)) {
            Arrays.sort(scoville);

            if (currentIdx >= scoville.length - 1) return -1;

            int a = scoville[currentIdx];
            int b = scoville[currentIdx + 1];

            int c = a + b * 2;

            scoville[currentIdx] = 0;
            scoville[currentIdx + 1] = c;
            currentIdx++;
            count++;
        }

        return count;
    }

    private static boolean isValid(int[] scoville, int K) {
        for (int element : scoville) {
            if (element != 0 && element < K) return false;
        }
        return true;
    }
}
