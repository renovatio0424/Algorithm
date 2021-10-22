package backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortNumber2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());

        boolean[] result = new boolean[2_000_000 + 1];

        for (int i = 0; i < n; i++) {
            int idx = Integer.parseInt(bufferedReader.readLine()) + 1_000_000;
            result[idx] = true;
        }

        for (int i = 0; i < result.length; i++) {
            if (result[i])
                stringBuilder.append(i - 1_000_000).append('\n');
        }

        System.out.println(stringBuilder.toString());
    }
}
