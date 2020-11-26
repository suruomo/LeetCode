package sort;

import java.util.Arrays;

/**
 * @author: suruomo
 * @date: 2020/11/26 15:13
 * @description: 164. 最大间距
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 */
public class MaximumGap {
    public static void main(String[] args) {
        int[] nums={3,6,9,1};
        System.out.println(maximumGap(nums));
    }

    private static int maximumGap(int[] nums) {
        if (nums.length==0||nums.length==1){
            return 0;
        }
        if (nums.length==2){
            return nums[1]-nums[0];
        }
        Arrays.sort(nums);
        int maxGap=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length-1; i++) {
                maxGap=Math.max(nums[i+1]-nums[i],maxGap);
        }
        return maxGap;
    }
}
