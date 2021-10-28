package backjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Budget {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] budgetArr = new int[n];
        String[] input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            budgetArr[i] = Integer.parseInt(input[i]);
        }

        int totalBudget = Integer.parseInt(bufferedReader.readLine());

        int result = getMaximumBudget(budgetArr, totalBudget);

        System.out.println(result);
    }

    private static int getMaximumBudget(int[] budgetArr, int totalBudget) {
        Arrays.sort(budgetArr);

        int start = 0;
        int end = budgetArr[budgetArr.length - 1];
        int max = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;

            for (int budget : budgetArr) {
                sum += Math.min(budget, mid);
            }

            if (sum > totalBudget) {
                end = mid - 1;
            } else {
                start = mid + 1;
                max = Math.max(max, mid);
            }
        }

        return max;
    }
}
