package interview;

import org.omg.CORBA.INTERNAL;

/**
 * @author: suruomo
 * @date: 2021/3/31 13:24
 * @description:
 * 假设你有一个数组，其中第 i 个元素是股票在第i 天的价格。
 * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
 */
public class MaxProfit {
    /**
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        int min=Integer.MAX_VALUE;
        int res=0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<min){
                min=prices[i];
            }
            res=Math.max(res,prices[i]-min);
        }
        return res;
    }

}
