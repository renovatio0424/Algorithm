package leet_code.two_pointers;

import java.util.Arrays;

public class MoveZeros {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int s = 0;
        int e = 0;

        while (e < nums.length) {
            while (nums[s] != 0) s++;
            e = s;
            while (e < nums.length && nums[e] == 0) e++;
            if (e >= nums.length) break;
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
        }
    }

    public static void moveZeroes2(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }

        while (pos < nums.length) {
            nums[pos] = 0;
            pos++;
        }
    }
}
