package backjoon.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SortInside {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int result = sortInside(N);

        System.out.print(result);
    }

    private static int sortInside(int n) {
        String number = String.valueOf(n);
        Integer[] numArr = new Integer[number.length()];

        for (int i = 0; i < number.length(); i++) {
            char element = number.charAt(i);
            numArr[i] = element - '0';
        }

        Arrays.sort(numArr, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int num : numArr) {
            sb.append(num);
        }
        return Integer.parseInt(sb.toString());
    }
}
