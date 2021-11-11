package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class SortCard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] cardArr = new int[n];

        for (int i = 0; i < n; i++) {
            cardArr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int result = solution(cardArr);

        System.out.println(result);
    }

    private static int calculateSortCount(int[] cardArr) {
        int sum = 0;

        for (int i = 0; i < cardArr.length - 1; i++) {
            sum += getMinTwoSum(cardArr);
        }

        return sum;
    }

    private static int getMinTwoSum(int[] cardArr) {
        Arrays.sort(cardArr);
        int numIdx = 0;

        while (cardArr[numIdx] == 0) numIdx++;
        if (numIdx >= cardArr.length - 1) return 0;
        int min = cardArr[numIdx] + cardArr[numIdx + 1];

        cardArr[numIdx] = 0;
        cardArr[numIdx + 1] = min;

        return min;
    }

    private static int solution(int[] cardArr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int count : cardArr) {
            pq.add(count);
        }

        int num = 0;
        //우선순위 큐에 2개이상 들어있어야 비교가 가능하다.
        while (pq.size() > 1) {
            int temp1 = pq.poll();
            int temp2 = pq.poll();

            num += temp1 + temp2;
            pq.add(temp1 + temp2); //합한 묶음 다시 넣기
        }

        return num;
    }
}
