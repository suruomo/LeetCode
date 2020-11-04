package dynamicplanning;

/**
 * @author: suruomo
 * @date: 2020/11/4 11:23
 * @description: 152.
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaxProduct {
    /**
     * 乘积会出现负负得正的情况，所以需要维护两个dp数组。
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int length = nums.length;
        // 表示以第 i 个元素结尾的乘积最大子数组的乘积
        int[] maxF = new int[length];
        // 表示以第 i 个元素结尾的乘积最小子数组的乘积
        int[] minF = new int[length];
        // 将原数组复制到两个dp数组中
        System.arraycopy(nums, 0, maxF, 0, length);
        System.arraycopy(nums, 0, minF, 0, length);
        // 动态规划过程
        for (int i = 1; i < length; ++i) {
            maxF[i] = Math.max(maxF[i - 1] * nums[i], Math.max(nums[i], minF[i - 1] * nums[i]));
            minF[i] = Math.min(minF[i - 1] * nums[i], Math.min(nums[i], maxF[i - 1] * nums[i]));
        }
        // 找出最大结果
        int ans = maxF[0];
        for (int i = 1; i < length; ++i) {
            ans = Math.max(ans, maxF[i]);
        }
        return ans;
    }

    /**
     * 只用两个变量来维护 i−1 时刻的状态
     * @param nums
     * @return
     */
    public int maxProduct1(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
}
