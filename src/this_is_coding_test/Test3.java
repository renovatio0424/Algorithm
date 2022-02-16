package this_is_coding_test;

import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        int[] A = new int[]{2};
        int[] B = new int[]{1, 1, 2};

        int result = solution(A, B);
        System.out.println(result);
    }

    public static int solution(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int i = 0;
        for (int k = 0; k < n; k++) {
            while (i <= m - 1 && B[i] < A[k])
                i += 1;
            if (A[k] == B[i])
                return A[k];
        }
        return -1;
    }
}
