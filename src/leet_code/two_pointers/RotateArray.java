package leet_code.two_pointers;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        int step = k % nums.length;
        int[] tempArr = new int[step];
        for (int i = 0; i < step; i++) {
            tempArr[i] = nums[nums.length - 1 - i];
        }

        for (int i = 0; i < nums.length - step; i++) {
            int temp = nums[nums.length - 1 - step - i];
            nums[nums.length - 1 - i] = temp;
        }

        for (int i = 0; i < tempArr.length; i++) {
            nums[step - i - 1] = tempArr[i];
        }
    }
}
