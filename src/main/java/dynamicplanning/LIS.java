package dynamicplanning;


/**
 * @author: suruomo
 * @date: 2020/11/4 10:47
 * @description: 300. 最长上升子序列
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class LIS {
    public static void main(String[] args) {
        int[] nums = {4,10,4,3,8,9};
        System.out.println(lengthOfLIS(nums));
    }

    /**
     * 1.最长上升子序列长度
     * @param nums
     * @return
     */
    private static int lengthOfLIS(int[] nums) {
        if (nums==null||nums.length==0){
            return 0;
        }
        int[] dp=new int[nums.length];
        dp[0]=1;
        int maxdp=1;
        int n=nums.length;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxdp = Math.max(maxdp, dp[i]);
        }
        return maxdp;
    }

    /**
     * 2.返回最长上升子序列
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public static int[] LIS (int[] arr) {
        // dp[i]表示以arr[i]结尾的最长上升子序列长度
        int[] dp=new int[arr.length];
        // 最大长度
        int maxLen=0;
        // 最大长度的最后一个元素下标
        int index=0;
        // 1.求每个位置的最大长度
        for (int i = 0; i < arr.length; i++) {
            dp[i]=1;
            for (int j = 0; j <i ; j++) {
                if (arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                if (dp[i]>maxLen){
                    maxLen=dp[i];
                    index=i;
                }
            }
        }
        // 2.求结果数组，从后向前
        int[] res=new int[maxLen];
        res[--maxLen]=arr[index];
        for (int i = index; i>=0; i--) {
            if ((arr[i]<arr[index])&&(dp[i]==dp[index]-1)){
                res[--maxLen]=arr[i];
                index=i;
            }
        }
        return res;
    }
}
