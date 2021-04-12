package interview;

/**
 * @author: suruomo
 * @date: 2021/4/12 10:35
 * @description: 给定两个字符串str1和str2，
 * 输出连个字符串的最长公共子序列。如过最长公共子序列为空，则输出-1。
 */
public class LCS1 {
    /**
     * longest common subsequence
     * @param s1 string字符串 the string
     * @param s2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String s1, String s2) {
       int len1=s1.length();
       int len2=s2.length();
       if (len1==0||len2==0){
           return "-1";
       }
       int[][] dp=new int[len1+1][len2+1];
       int[][] flag=new int[len1+1][len2+1];
        for (int i = 1; i <=len1 ; i++) {
            for (int j = 1; j <len2; j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    flag[i][j]=1;
                }else if (dp[i-1][j]>=dp[i][j-1]){
                    dp[i][j]=dp[i-1][j];
                    flag[i][j]=2;
                }else {
                    dp[i][j]=dp[i][j-1];
                    flag[i][j]=3;
                }
            }
        }
        int i=len1;
        int j=len2;
        StringBuilder s=new StringBuilder();
        while (i>=0&&j>=0){
            if (flag[i][j]==1){
                i--;
                j--;
                s.append(s1.charAt(i));
            }else if(flag[i][j]==2){
                i--;
            }else {
                j--;
            }
        }
        return s.length()>0?s.reverse().toString():"-1";
    }
}
