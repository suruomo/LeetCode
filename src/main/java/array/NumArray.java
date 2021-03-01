package array;

/**
 * @author: suruomo
 * @date: 2021/3/1 9:29
 * @description: 303. 区域和检索 - 数组不可变
 * 时间复杂度降到 O(1)
 */
public class NumArray {
    int[] sums;

    /**
     * 初始化
     * @param nums
     */
    public NumArray(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        // 当 0<i≤n 时，sums[i]表示数组nums 从下标 0 到下标i−1 的前缀和
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}
