package backtracking;

/**
 * @author: suruomo
 * @date: 2021/6/7 9:37
 * @description: 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class FindTargetSumWays {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    /**
     * 回溯
     * @param nums
     * @param target
     * @param index 当前遍历位置
     * @param sum 当前遍历总和
     */
    public void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }
}
