package dynamicplanning;

/**
 * @author: suruomo
 * @date: 2021/1/9 11:45
 * @description: 121. 买卖股票的最佳时机
 * 给定一个数组，它的第i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意：你不能在买入股票前卖出股票。
 *
 */
public class MaxProfit1 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int minProfit=Integer.MAX_VALUE;
        int maxProfit=0;
        for (int i = 0; i < n; i++) {
            if (prices[i] < minProfit) {
                minProfit = prices[i];
            } else if (prices[i] - minProfit > maxProfit) {
                maxProfit = prices[i] - minProfit;
            }
        }
        return maxProfit;
    }
}
