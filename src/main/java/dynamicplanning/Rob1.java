package dynamicplanning;

/**
 * 问题：198 打家劫舍
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *
 * @author 苏若墨
 */
public class Rob1 {
    public static void main(String[] args) {
        int[] nums = {2, 5, 42, 15, 9, 6};
        System.out.println("寻常思路：抢劫最大金额是：" + rob(nums));
        System.out.println("简化代码：抢劫最大金额是：" + rob1(nums));
    }

    private static int rob1(int[] nums) {
        int preMax = 0;
        int curMax = 0;
        for (int num : nums) {
            int temp = curMax;
            curMax = Math.max(preMax + num, curMax);
            preMax = temp;
        }
        return curMax;
    }

    private static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] max = new int[len + 1];
        max[0] = 0;
        max[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            max[i] = Math.max(max[i - 1], max[i - 2] + nums[i - 1]);
        }
        return max[len];
    }
}
