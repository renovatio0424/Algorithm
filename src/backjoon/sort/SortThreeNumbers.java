package backjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

public class SortThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = new int[3];
        for (int i = 0; i < 3; i++) {
            arr[i] = scanner.nextInt();
        }

        Arrays.sort(arr);

        for (int number : arr) {
            System.out.print(number + " ");
        }
    }
}
