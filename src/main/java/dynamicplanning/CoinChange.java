package dynamicplanning;

import java.util.Arrays;

/**
 * @author: suruomo
 * @date: 2021/3/4 11:04
 * @description: 322. 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp=new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for (int i = 1; i <=amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // 如果当前硬币可以满足零钱兑换
                if (i>=coins[j]){
                        dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]>amount?-1:dp[amount];
    }
}
