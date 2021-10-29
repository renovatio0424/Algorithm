package backjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CutTree {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputArr = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(inputArr[0]);
        int m = Integer.parseInt(inputArr[1]);

        String[] inputTreeArr = bufferedReader.readLine().split(" ");
        int[] treeArr = new int[n];

        for (int i = 0; i < treeArr.length; i++) {
            treeArr[i] = Integer.parseInt(inputTreeArr[i]);
        }

        int result = getMaximumCutHeight(treeArr, m);

        System.out.println(result);
    }

    private static int getMaximumCutHeight(int[] treeArr, int target) {
        Arrays.sort(treeArr);
        int start = 0;
        int end = treeArr[treeArr.length - 1];
        int height = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            long treeSum = 0;

            for (int treeHeight : treeArr) {
                if (treeHeight > mid) {
                    treeSum += treeHeight - mid;
                }
            }

            if (treeSum >= target) {
                start = mid + 1;
                height = Math.max(height, mid);
            } else {
                end = mid - 1;
            }
        }

        return height;
    }
}
