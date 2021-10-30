package programmers.binary_search;

import java.util.Arrays;

public class EnterTest {
    public static void main(String[] args) {
        int[] times = new int[]{1_000_000_000};
        int n = 1_000_000_000;

        long result = solution(n, times);

        System.out.println(result);
    }

    private static long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 0;
        long end = (long) times[times.length - 1] * n;
        long answer = end;

        while (start <= end) {
            long mid = (start + end) / 2;
            long count = 0;

            for (int time : times) {
                count += mid / time;
            }

            if (count >= n) {
                end = mid - 1;
                answer = Math.min(mid, answer);
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }


}
