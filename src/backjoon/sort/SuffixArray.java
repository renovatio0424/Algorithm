package backjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SuffixArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String inputString = bufferedReader.readLine();
        String[] stringArr = new String[inputString.length()];

        for (int i = 0; i < inputString.length(); i++) {
            stringArr[i] = inputString.substring(i);
        }

        Arrays.sort(stringArr);

        for (String result : stringArr) {
            System.out.println(result);
        }
    }
}
