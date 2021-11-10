package leet_code.two_pointers;

import java.util.Arrays;

public class TwoSum2 {
    public static void main(String[] args) {
        int[] numbers = new int[]{5, 25, 75};
        int target = 100;

        int[] result = twoSum(numbers, target);

        System.out.println(Arrays.toString(result));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int s = 0;
        int e = 1;

        while (s < numbers.length && e < numbers.length) {
            int sum = numbers[s] + numbers[e];

            if (sum == target) break;

            e++;

            if (e >= numbers.length) {
                s++;
                e = s + 1;
            }
        }

        return new int[]{s + 1, e + 1};
    }
}
