package dynamicplanning;

/**
 * @author: suruomo
 * @date: 2021/1/9 11:37
 * @description: 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
 *
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 */
public class MaxProfit3 {
    /**
     * 动态规划数组
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp=new int[n][5];
        // 1.没有操作
        dp[0][0]=0;
        // 2.第一次买入
        dp[0][1]=-prices[0];
        // 3.第一次卖出
        dp[0][2]=0;
        // 4.第二次买入
        dp[0][3]=-prices[0];
        // 5.第二次卖出
        dp[0][4]=0;
        for (int i = 1; i < n; i++) {
            dp[i][0]=dp[i-1][0];
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4]=Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }
        return dp[n-1][4];
    }
    /**
     * 优化空间解法
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        // 只进行了一次买操作
        int buy1 = -prices[0];
        // 进行了一笔买和一笔卖操作，即完成一笔交易
        int sell1 = 0;
        // 在完成一笔交易的前提下，进行第二次买操作
        int buy2 = -prices[0];
        // 完成两笔交易
        int sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
