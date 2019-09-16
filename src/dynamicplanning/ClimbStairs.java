package dynamicplanning;

/**
 * 问题：假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * @author 苏若墨
 */
public class ClimbStairs {
    public static void main(String[] args) {
        int n=10;
        System.out.printf("暴力递归：一共有%d种解法\n",climbStairs(0,n));
        System.out.printf("动态规划：一共有%d种解法",dynamicclimbStairs(n));
    }

    /**
     * 动态规划解法
     * d[n]表示到达第n阶时有多少解法，到达第n阶的方法总数就是到第(n−1) 阶和第(n−2) 阶的方法数之和。
     * @param n 目标阶数
     * @return 返回结果
     */
    private static int dynamicclimbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 暴力递归法
     * 每一次只有跳一阶和跳两阶两种可能
     * @param i 当前阶数
     * @param n 目标阶数
     * @return 返回结果
     */
    private static int climbStairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }
}
