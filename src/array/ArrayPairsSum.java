package array;

import java.util.Arrays;

/**
 * @author 苏若墨
 * 问题：给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
 * 使得从1 到 n 的 min(ai, bi) 总和最大。
 * 思路： 数对必是有序数列上相邻元素
 */
public class ArrayPairsSum {
    public static void main(String[] args) {
        int[] nums={1,3,2,4};
        parisSum(nums);
    }

    private static void parisSum(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for(int i=0;i<nums.length;i+=2){
            sum+=nums[i];
        }
        System.out.println(sum);
    }
}
