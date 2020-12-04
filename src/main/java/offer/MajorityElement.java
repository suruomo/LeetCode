package offer;

import java.util.Arrays;

/**
 * @author: suruomo
 * @date: 2020/12/4 10:58
 * @description:  39. 数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int mid=(nums.length-1)/2;
        return nums[mid];
    }
}
