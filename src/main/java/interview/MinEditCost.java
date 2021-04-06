package interview;

/**
 * @author: suruomo
 * @date: 2021/4/2 13:31
 * @description:
 */
public class MinEditCost {
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        // write code here
        int m = str1.length();
        int n = str2.length();
        // dp[i][j]表示word1的前i个字符编辑成word2的前j个字符需要的最小操作数
        int[][] dp = new int[m+1][n+1];
        // 前i个删除代价
        for(int i = 1; i <= m; i++) {
            dp[i][0] = i*dc;
        }
        // 前j个插入代价
        for(int j = 1; j <= n; j++) {
            dp[0][j] = j*ic;
        }
        for(int i = 1; i <= m; i++) {
            char c1 = str1.charAt(i-1);
            for(int j = 1; j <= n; j++) {
                char c2 = str2.charAt(j-1);
                if(c1 == c2) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int insert = dp[i][j-1] + ic;
                    int delete = dp[i-1][j] + dc;
                    int replace = dp[i-1][j-1] + rc;
                    dp[i][j] = Math.min(replace, Math.min(insert, delete));
                }
            }
        }
        return dp[m][n];
    }
}
