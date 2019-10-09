package dynamicplanning;

/**
 * 问题：斐波那契数列
 * 思路：
 * 动态规划
 *
 * @author 苏若墨
 */
public class Fibonacci {
    public static void main(String[] args) {
        int n = 10;
        System.out.println(fibonacci(n));

    }

    private static int fibonacci(int n) {
        int[] nums = new int[n + 1];
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n];
    }
}
