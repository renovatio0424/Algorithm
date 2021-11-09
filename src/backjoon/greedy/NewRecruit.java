package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NewRecruit {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] score = new int[n + 1];

            for (int j = 0; j < n; j++) {
                String[] input = bufferedReader.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);
                score[a] = b;
            }
            sb.append(countMaximumRecruit(score));
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static int countMaximumRecruit(int[] scoreArr) {
        int count = 0;
        int prev = scoreArr.length;
        for (int i = 1; i < scoreArr.length; i++) {
            int score = scoreArr[i];
            if (prev < score) {
                count++;
            } else {
                prev = score;
            }
        }
        return scoreArr.length - 1 - count;
    }
}
