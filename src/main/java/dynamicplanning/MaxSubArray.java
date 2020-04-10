package dynamicplanning;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 问题：
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 * 思路：
 * dp[i] 代表以元素 nums[i]为结尾的连续子数组最大和。
 * 当 dp[i - 1] > 0dp[i−1]>0 时：执行 dp[i] = dp[i-1] + nums[i]dp[i]=dp[i−1]+nums[i] ；
 * 当 dp[i - 1] \leq 0dp[i−1]≤0 时：执行 dp[i] = nums[i]dp[i]=nums[i] ；
 * @author 苏若墨
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] array={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(array));
        System.out.println(maxOptSubArray(array));
    }

    /**
     * 优化后，空间复杂度是O(1)
     * @param array
     * @return
     */
    private static int maxOptSubArray(int[] array) {
        int res=array[0];
        for(int i=1;i<array.length;i++){
            array[i]+=Math.max(array[i-1],0);
            res=Math.max(res,array[i]);
        }
        return res;
    }

    /**
     * 未优化,空间复杂度是O(n)
     * @param array
     * @return
     */
    private static int maxSubArray(int[] array) {
        int[] dp=new int[array.length];
        dp[0]=array[0];
        for(int i=1;i<array.length;i++){
            if(dp[i-1]<=0){
                dp[i]=array[i];
            }
            else{
                dp[i]=dp[i-1]+array[i];
            }
        }
        Arrays.sort(dp);
        return dp[dp.length-1];
    }

}
