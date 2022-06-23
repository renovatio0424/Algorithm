package backjoon.two_pointer;

import java.util.Scanner;

public class SumOfNumber2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int answer = solution(m, arr);

        System.out.println(answer);
    }

    private static int solution(int m, int[] arr) {
        int s = 0;
        int e = 0;
        int sum = 0;
        int count = 0;

        while (true) {
            if (sum >= m) {
                sum -= arr[s++];
            } else if (e >= arr.length) {
                break;
            } else {
                sum += arr[e++];
            }

            if (sum == m) count++;
        }

        return count;
    }
}
