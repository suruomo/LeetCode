package interview;

/**
 * @author: suruomo
 * @date: 2021/3/26 12:55
 * @description: 给定一个数组arr，返回子数组的最大累加和
 */
public class MaxSumOfSubarray {
    /**
     * max sum of the subarray
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxsumofSubarray (int[] arr) {
        // write code here
        int[] dp=new int[arr.length];
        int max=arr[0];
        dp[0]=arr[0];
        for (int i = 1; i <arr.length; i++) {
            if (dp[i-1]<0){
                dp[i]=arr[i];
            }else {
                dp[i]=dp[i-1]+arr[i];
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
