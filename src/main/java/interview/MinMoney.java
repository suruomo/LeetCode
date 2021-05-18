package interview;

import java.util.Arrays;

/**
 * @Author: suruomo
 * @Date: 2021/5/18 11:09
 * @Description: 给定数组arr，arr中所有的值都为正整数且不重复。
 * 每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
 * 如果无解，请返回-1.
 */
public class MinMoney {
    public static int minMoney (int[] arr, int aim) {
        int[] count = new int[aim +1];
        Arrays.fill(count, aim + 1);
        //初始化数组
        count[0] = 0;
        for (int i =1;i<=aim;i++){
            for (int j = 0 ; j < arr.length ; j++){
                if (i >=arr[j]){
                    //当前的钱数-当前面值，为之前换过的钱数，如果能够兑换只需要在加+1即可，如果不能就取aim+1;
                    count[i] = Math.min(count[i-arr[j]] +1 , count[i]);
                }
            }
        }
        //对应的总数是否能够兑换取决于是否等于aim+1
        return count[aim] != aim+1 ? count[aim] :-1;
    }
}
