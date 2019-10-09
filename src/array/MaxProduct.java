package array;

import java.util.Arrays;

public class MaxProduct {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 5, 7};
        maxProduct(nums);

    }

    private static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int r1 = 0, r2 = 0;
        r1 = nums[0] * nums[1] * nums[nums.length - 1];
        r2 = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        return r1 > r2 ? r1 : r2;
    }
}
