package this_is_coding_test.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        int[] result = selectSorting(arr);

        System.out.println(Arrays.toString(result));
    }

    private static int[] selectSorting(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIdx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIdx] > arr[j])
                    minIdx = j;
            }

            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }

        return arr;
    }
}
