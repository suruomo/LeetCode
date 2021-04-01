package dynamicplanning;

/**
 * @author: suruomo
 * @date: 2021/3/16 12:16
 * @description: 1143. 最长公共子序列
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String s1="abchbckas";
        String s2="dackbcjas";
        longestCommonSubsequence(s1,s2);
    }
    /**
     * 1.返回最长公共子序列的长度
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequenceLength(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();
        // dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
        int[][] dp = new int[len1+1][len2+1];

        for (int i=1; i<=len1; ++i) {
            for (int j=1; j<=len2; ++j) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    /**
     * 2.返回最长公共子序列
     * @param s1
     * @param s2
     * @return
     */
    public static void longestCommonSubsequence(String s1, String s2) {
        int len1=s1.length();
        int len2=s2.length();
        // dp数组，保存最大长度
        int[][] dp=new int[len1+1][len2+1];
        // 标志数组，记录当前状态是从哪个状态转变过来的（三种）
        int[][] flag=new int[len1+1][len2+1];
        // 1.填充dp和flag
        for (int i = 1; i <=len1; i++) {
            for (int j = 1; j <=len2; j++) {
                // 1.第一种状态
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    flag[i][j]=1;
                // 2.第二种状态
                }else if (dp[i-1][j]>=dp[i][j-1]){
                    dp[i][j]=dp[i-1][j];
                    flag[i][j]=0;
                // 3.第三种状态
                }else {
                    dp[i][j]=dp[i][j-1];
                    flag[i][j]=-1;
                }
            }
        }
        if (len1<len2){
            String t=s1;
            s1=s2;
            s2=t;
        }
        // 2.回溯较长字符串找结果
        display(s1,flag,len1,len2);
    }

    /**
     * 递归查找结果
     * @param s1
     * @param flag
     * @param i
     * @param j
     */
    private static void display(String s1, int[][] flag, int i, int j) {
        if(i == 0 || j == 0) {
            return;
        }
        if(flag[i][j] == 1)
        {
            display(s1, flag, i-1, j-1);
            System.out.print(s1.charAt(i-1) + " ");
        }
        else if(flag[i][j] == 0)
        {
            display(s1, flag, i-1, j);
        }
        else if(flag[i][j] == -1)
        {
            display(s1, flag,  i, j-1);
        }
    }
}
