/**
 * @author 苏若墨
 * 问题：给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * 思路;维持两个变量——minprice 和 maxprofit，
 * 它们分别对应迄今为止所得到的最小的谷值和最大的利润（卖出价格与最低价格之间的最大差值）。
 *
 */
public class MaxProfit {
    public static void main(String[] args) {
        int[] prices={1,7,3};
        maxProfit(prices);
    }

    private static void maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice){
                //低谷值
                minprice = prices[i];
            }
            //如果当前卖出价格减去低谷值大于最大利润，记住当前最大利润
            else if (prices[i] - minprice > maxprofit){
                maxprofit = prices[i] - minprice;
            }
        }
       System.out.println("最大利润是："+maxprofit);
    }
}
