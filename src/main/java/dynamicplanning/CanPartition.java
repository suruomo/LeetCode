package dynamicplanning;

/**
 * @author: suruomo
 * @date: 2020/10/11 13:45
 * @description: 416. 分割等和子集
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        // 判断条件1：如果数组长度小于2，返回false
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        // 判断条件2：如果数组和为奇数，肯定无法分为两个和相等子集，返回false
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // 判断条件3：如果数组最大数字大于target，剩下部分肯定小于target，返回false
        if (maxNum > target) {
            return false;
        }
        // dp[i][j] 表示从数组的 [0,i] 下标范围内选取若干个正整数（可以是 0 个）
        // 是否存在一种选取方案使得被选取的正整数的和等于 j。
        boolean[][] dp = new boolean[n][target + 1];
        // 边界情况1：不选取任何正整数
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        // 边界情况2：当i==0 时，只有一个正整数 nums[0] 可以被选取
        dp[0][nums[0]] = true;
        // 动态规划过程
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    // 如果j>nums[i],可选可不选
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    // 如果j<nums[i]，则在选取的数字的和等于 j 的情况下无法选取当前的数字nums[i]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }
}
