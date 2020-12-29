package offer;

/**
 * @author: suruomo
 * @date: 2020/12/29 14:09
 * @description: 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 */
public class MaxProfit {
    /**
     * 一次遍历，找到峰顶和峰谷
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 最低值
        int minProfit=Integer.MAX_VALUE;
        // 最大利润
        int maxProfit=0;
        int n=prices.length;
        for (int i = 0; i < n; i++) {
            if (prices[i]<minProfit){
                minProfit= prices[i];
            }else if (maxProfit<prices[i]-minProfit){
                maxProfit=prices[i]-minProfit;
            }
        }
        return maxProfit;
    }
}
