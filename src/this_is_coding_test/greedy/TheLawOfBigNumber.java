package this_is_coding_test.greedy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class TheLawOfBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArr = input.split(" ");
        int N = Integer.parseInt(inputArr[0]);
        int M = Integer.parseInt(inputArr[1]);
        int K = Integer.parseInt(inputArr[2]);

        Integer numberArr[] = new Integer[N];
        for (int i = 0; i < N; i++) {
            numberArr[i] = scanner.nextInt();
        }

        int result = getBigNumber(M, K, numberArr);

        System.out.println(result);
    }

    private static int getBigNumber(int m, int k, Integer[] numberArr) {
        Arrays.sort(numberArr, Collections.reverseOrder());
        int sum = 0;

        int a = numberArr[0];
        int b = numberArr[1];

        if (a == b) {
            sum = a * k;
            return sum;
        }

        int quotient = m / k;
        int remain = m % k;

        sum = quotient * k * a + remain * b;

        return sum;
    }

}
