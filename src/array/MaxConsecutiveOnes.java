package array;

/**
 * @author 苏若墨
 *
 * 问题：：给定一个二进制数组， 计算其中最大连续1的个数。
 * 示例 1:
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 *
 *
 * 思路：
 *
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums={1,1,0,0,1,1,1};
        consecutive(nums);
    }

    private static int consecutive(int[] nums) {
        int count=0;
        int max=0;
        if(nums.length==1&&nums[0]==1){
            return 1;
        }
        for(int num:nums){
            if(num==1){
                count++;
            }
            else{
                max=max>count?max:count;
                count=0;
            }
        }
        return max>count?max:count;
    }
}
