package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Treasure {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] a = new int[n];
        Integer[] b = new Integer[n];

        String[] input1 = bufferedReader.readLine().split(" ");
        String[] input2 = bufferedReader.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input1[i]);
            b[i] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(a);

        Arrays.sort(b, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += a[i] * b[i];
        }
        System.out.println(result);
    }
}
