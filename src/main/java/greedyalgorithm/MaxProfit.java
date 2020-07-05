package greedyalgorithm;

/**
 * @author suruomo
 * @date 2020/7/5 16:33
 * @description:122：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices={7,1,5,3,6,4};
        System.out.println("最大利益："+maxPrices(prices));
    }

    /**
     * 画图，连续差值等于峰谷差值
     * @param prices
     * @return
     */
    private static int maxPrices(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }
}
