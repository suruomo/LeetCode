package dynamicplanning;

/**
 * @author: suruomo
 * @date: 2021/3/16 12:07
 * @description: 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 */
public class FindLength {
    public int findLength(int[] A, int[] B) {
        // dp[i][j]表示下标i-1,j-1的最长
        int[][] dp=new int[A.length+1][B.length+1];
        dp[0][0]=0;
        int ans=0;
        for (int i = 1; i <=A.length; i++) {
            for (int j = 1; j <=B.length; j++) {
                if (A[i-1]==B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}
