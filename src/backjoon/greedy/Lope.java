package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lope {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());

        int[] lopeArr = new int[n];

        for (int i = 0; i < lopeArr.length; i++) {
            lopeArr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        int result = getMaximumWeight(lopeArr);

        System.out.println(result);
    }

    private static int getMaximumWeight(int[] lopeArr) {
        Arrays.sort(lopeArr);
        int max = 0;
        for (int i = 0; i < lopeArr.length; i++) {
            int weight = lopeArr[i] * (lopeArr.length - i);

            if (max < weight) max = weight;
        }
        return max;
    }
}
