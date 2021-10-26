package backjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SearchNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr1 = new int[n];
        String input = bufferedReader.readLine();
        String[] inputArr = input.split(" ");

        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(inputArr[i]);
        }

        int m = Integer.parseInt(bufferedReader.readLine());
        int[] arr2 = new int[m];

        String input2 = bufferedReader.readLine();
        String[] inputArr2 = input2.split(" ");

        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(inputArr2[i]);
        }

        Arrays.sort(arr1);

        for (int target : arr2) {
            int result = binarySearch(arr1, target);

            if (result < 0)
                result = 0;
            else
                result = 1;

            System.out.println(result);
        }
    }

    private static int binarySearch(int[] arr1, int target) {
        int start = 0;
        int end = arr1.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr1[mid] == target) {
                return 1;
            } else if (arr1[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return 0;
    }
}
