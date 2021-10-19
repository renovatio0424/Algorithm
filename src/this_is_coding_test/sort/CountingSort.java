package this_is_coding_test.sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = new int[]{
                7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2
        };

        int[] sortedArr = countSorting(arr);

        System.out.println(Arrays.toString(sortedArr));
    }

    private static int[] countSorting(int[] arr) {
        int[] resultArr = new int[arr.length];
        int[] countArr = new int[arr.length];

        for (int element : arr) {
            countArr[element]++;
        }

        int idx = 0;

        for (int i = 0; i < countArr.length; i++) {
            if (countArr[i] == 0) continue;

            for (int j = 0; j < countArr[i]; j++) {
                resultArr[idx+j] = i;
            }

            idx += countArr[i];
        }

        return resultArr;
    }
}
