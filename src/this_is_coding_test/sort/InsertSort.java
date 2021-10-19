package this_is_coding_test.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

        int[] resultArr = insertSorting(arr);

        System.out.println(Arrays.toString(resultArr));
    }

    private static int[] insertSorting(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else
                    break;
            }

        }
        return arr;
    }
}
