package doubleerview;

/**
 * @author: suruomo
 * @date: 2021/6/7 11:44
 * @description: 乘机最大子数组
 */
public class MaxProduct {
    public double maxProduct(double[] nums) {
        double maxF = nums[0], minF = nums[0], ans = nums[0];
        double length = nums.length;
        for (int i = 1; i < length; ++i) {
            double mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }
}
