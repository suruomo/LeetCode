package offer;

/**
 * @author suruomo
 * @date 2020/7/16 19:25
 * @description: 剑指Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * 思路：二分法
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        //当 i ≤j 时循环 （即当闭区间 [i, j]为空时跳出） ；
        //计算中点 m = (i + j) / 2，其中 "/" 为向下取整除法；
        //若 nums[m] =m ，则 “右子数组的首位元素” 一定在闭区间 [m + 1, j]中，因此执行 i = m + 1；
        //若 nums[m] !=m]，则 “左子数组的末位元素” 一定在闭区间 [i, m - 1] 中，因此执行 j = m - 1；
        //缺失的数字等于 “右子数组的首位元素” 对应的索引
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }
}
