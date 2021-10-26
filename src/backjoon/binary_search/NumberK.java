package backjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberK {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int k = Integer.parseInt(bufferedReader.readLine());

        int result = searchNumber(n, k);

        System.out.println(result);
    }

    private static int searchNumber(int n, int k) {
        int start = 1;
        int end = k;
        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int count = 0;

            for (int i = 1; i <= n; i++) {
                count += Math.min(mid/i, n);
            }

            if (count < k) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }

        return result;
    }
}
