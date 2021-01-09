package dynamicplanning;

/**
 * @author: suruomo
 * @date: 2020/12/17 9:29
 * @description: 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 * 本部分为动态规划解法，贪心解法详情见其他部分
 */
public class MaxProfit2 {
    /**
     * 动态规划 1：使用数组
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int len= prices.length;
        int[][] dp=new int[len][2];
        // dp[i][0]表示第i天交易结束！！后没有股票的最大收益
        dp[0][0]=0;
        // dp[i][1]表示第i天交易结束！！后有股票的最大收益
        dp[0][1]=-prices[0];
        for (int i = 1; i < len; i++) {
            // 1.前一天已经没有股票
            // 2.前一天结束的时候手里持有一支股票，即dp[i-1][1]，这时候我们要将其卖出，并获得prices[i] 的收益
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            // 1.前一天结束手里已经有一支股票
            // 2.前一天结束时还没有股票，即dp[i−1][0]，这时候我们要将其买入，并减少prices[i] 的收益
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }
        return dp[len-1][0];
    }

    /**
     * 动态规划 2：使用两个变量存储，进行空间优化
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int len= prices.length;
        int dp0=0;
        int dp1=-prices[0];
        for (int i = 1; i < len; i++) {
            int new0=Math.max(dp0,dp1+ prices[i]);
            int new1=Math.max(dp1,dp0-prices[i]);
            dp0=new0;
            dp1=new1;
        }
        return dp0;
    }
}
