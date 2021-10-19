package this_is_coding_test.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TopDown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());

        for (int number : arr) {
            System.out.println(number);
        }
    }
}
