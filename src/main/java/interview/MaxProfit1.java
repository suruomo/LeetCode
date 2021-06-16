package interview;

/**
 * @author: suruomo
 * @date: 2021/6/16 13:51
 * @description: 股票交易的最大收益（二）
 * 最多进行两笔交易
 */
public class MaxProfit1 {
    public int maxProfit (int[] prices) {
        int n = prices.length;
        int[][] dp=new int[n][4];
        // 1.第一次买入
        dp[0][0]=-prices[0];
        // 2.第一次卖出
        dp[0][1]=0;
        // 3.第二次买入
        dp[0][2]=-prices[0];
        // 4.第二次卖出
        dp[0][3]=0;
        for (int i = 1; i < n; i++) {
            dp[i][0]=Math.max(dp[i-1][0],-prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]-prices[i]);
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]+prices[i]);
        }
        return dp[n-1][3];
    }
}
