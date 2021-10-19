package this_is_coding_test.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 7, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSorting(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    private static void quickSorting(int[] arr, int startIdx, int endIdx) {
        if (startIdx >= endIdx) return;

        int pivot = startIdx;
        int left = startIdx + 1;
        int right = endIdx;

        while (left <= right) {
            while (left < arr.length - 1 && arr[left] < arr[pivot]) left++;
            while (right >= 0 && arr[right] > arr[pivot]) right--;

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
        }

        int temp = arr[pivot];
        arr[pivot] = arr[left];
        arr[left] = temp;

        quickSorting(arr, 0, right);
        quickSorting(arr, right + 1, endIdx);
    }
}
