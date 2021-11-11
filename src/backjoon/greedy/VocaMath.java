package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class VocaMath {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        String[] wordArr = new String[n];

        for (int i = 0; i < n; i++) {
            wordArr[i] = bufferedReader.readLine();
        }

        int result = getMaxSum(wordArr);
        System.out.println(result);
    }

    private static int getMaxSum(String[] wordArr) {
        Integer[] valueArr = new Integer[30];
        Arrays.fill(valueArr, 0);
        for (String word : wordArr) {
            for (int i = 0; i < word.length(); i++) {
                char a = word.charAt(i);
                valueArr[a - 'A'] += (int) Math.pow(10, word.length() - 1 - i);
            }
        }

        Arrays.sort(valueArr, Collections.reverseOrder());

        int sum = 0;
        int idx = 0;
        for (int i = 9; i >= 0; i--) {
            sum += valueArr[idx] * i;
            idx++;
        }
        return sum;
    }
}
