package offer;

import java.util.Arrays;

/**
 * @author: suruomo
 * @date: 2020/11/27 15:04
 * @description: 剑指 Offer 03. 数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 */
public class FindRepeatNumber {
    public static void main(String[] args) {
        int[] nums={2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }

    private static int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        int res=0;
        for (int i = 0; i < len-1; i++) {
            if (nums[i]==nums[i+1]){
                res=nums[i];
            }
        }
        return res;
    }
}
