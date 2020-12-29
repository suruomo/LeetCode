package dynamicplanning;


import java.util.Arrays;

/**
 * @author: suruomo
 * @date: 2020/12/28 11:53
 * @description: 188. 买卖股票的最佳时机 IV
 * 给定一个整数数组prices ，它的第 i 个元素prices[i] 是一支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
 *
 * 卖出算一笔交易完成！！！！
 *
 */
public class MaxProfit3 {
    public int maxProfit(int k, int[] prices) {
        if(prices==null||prices.length==0){
            return 0;
        }
        int n= prices.length;
        // 所以由于一买一卖，交易肯定不会大于n/2
        k=Math.min(k,n/2);
        // buy[i][j] 表示对于数组prices[0..i]中的价格而言，进行恰好j笔交易
        // 并且当前手上持有一支股票，这种情况下的最大利润
        int[][] buy=new int[n][k+1];
        // sell[i][j] 表示对于数组prices[0..i]中的价格而言，进行恰好j笔交易
        // 并且当前手上没有一支股票，这种情况下的最大利润
        int[][] sell=new int[n][k+1];
        buy[0][0]=-prices[0];
        sell[0][0]=0;
        for (int i = 0; i <=k; i++) {
            buy[0][i]= sell[0][i]=Integer.MIN_VALUE/2;
        }
        for (int i = 1; i < n; i++) {
            buy[i][0]= Math.max(buy[i-1][0], sell[i-1][0]-prices[i]);
            for (int j = 1; j <=k; j++) {
                buy[i][j]= Math.max(buy[i-1][j], sell[i-1][j]-prices[i]);
                sell[i][j]= Math.max(sell[i-1][0], buy[i-1][j-1]+prices[i]);
            }
        }
        // 最终的答案即为sell[n−1][0..k] 中的最大值。
        return Arrays.stream(sell[n-1]).max().getAsInt();
    }

    /**
     * 优化空间
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit1(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[i] = sell[i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell).max().getAsInt();
    }
}
