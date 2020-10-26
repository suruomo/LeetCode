package array;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author: suruomo
 * @date: 2020/10/26 9:40
 * @description: 1365 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 */
public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {
        int[] nums={8,1,2,2,3};
        System.out.println(smallerNumbersThanCurrent(nums));
    }

    private static int[] smallerNumbersThanCurrent(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] nums_copy=Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums_copy);
        for (int i = nums_copy.length-1; i>=0; i--) {
            map.put(nums_copy[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            nums_copy[i]=map.get(nums[i]);
        }
        return nums_copy;
    }
}
