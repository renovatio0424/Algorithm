package programmers.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MoreSpicy {
    public static void main(String[] args) {
        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int K = 7;
        int result = solution(scoville, K);
        System.out.println(result);
    }

    private static int solution(int[] scoville, int K) {
        int mixCount = 0;
        PriorityQueue<Integer> scovilleQueue = new PriorityQueue<>();

        for (int element : scoville) {
            scovilleQueue.offer(element);
        }

        while (scovilleQueue.peek() <= K) {
            if (scovilleQueue.size() <= 1) return -1;

            int arg1 = scovilleQueue.poll();
            int arg2 = scovilleQueue.poll();

            int mix = mix(arg1, arg2);
            scovilleQueue.offer(mix);
            mixCount++;
        }

        return mixCount;
    }

    private static int mix(int arg1, int arg2) {
        return arg1 + 2 * arg2;
    }

    private static void addAsc(ArrayList<Integer> resultList, int mix) {
        //[3,9,10,12] <- 5
        for (int i = 0; i < resultList.size(); i++) {
            int element = resultList.get(i);
            if (element > mix) {
                resultList.add(i, mix);
                return;
            }
        }
        resultList.add(mix);
    }

    private static void addAsc2(ArrayList<Integer> resultList, int mix) {
        int start = 0;
        int end = resultList.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int midValue = resultList.get(mid);

            if (midValue < mix) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        resultList.add(start, mix);
    }
}
