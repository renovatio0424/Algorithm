package this_is_coding_test.binary_search;

import java.io.IOException;
import java.util.Arrays;

public class DducBokki {
    public static void main(String[] args) throws IOException {
        int n = 4;
        int m = 6;

        int[] dducArr = new int[]{19, 15, 10, 17};
        Arrays.sort(dducArr);

        int result = getMaxHeight(dducArr, m, dducArr[0], dducArr[dducArr.length - 1]);

        System.out.println(result);
    }

    private static int getMaxHeight(int[] dducArr, int m, int start, int end) {
        if (start >= end)
            return -1;

        int mid = (start + end) / 2;
        int sum = 0;

        for (int dduc : dducArr) {
            if (dduc - mid > 0)
                sum += dduc - mid;
        }

        if (sum > m)
            return getMaxHeight(dducArr, m, mid, end - 1);
        else if (sum < m)
            return getMaxHeight(dducArr, m, start + 1, mid);
        else
            return mid;
    }
}
