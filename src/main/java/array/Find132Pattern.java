package array;

/**
 * @author: suruomo
 * @date: 2021/3/24 10:46
 * @description: 456. 132 模式
 * 给你一个整数数组 nums ，数组中共有 n 个整数。
 * 132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，
 * 并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
 *
 * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false
 *
 */
public class Find132Pattern {
    public boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if(nums[i]<nums[k]&&nums[k]<nums[j]){
                        return true;
                    }
                }
            }

        }
        return false;
    }
}
