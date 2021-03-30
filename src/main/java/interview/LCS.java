package interview;

/**
 * @author: suruomo
 * @date: 2021/3/30 10:21
 * @description: 给定两个字符串str1和str2, 输出两个字符串的最长公共子串
 * 题目保证str1和str2的最长公共子串存在且唯一。
 */
public class LCS {
    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        int len1=str1.length();
        int len2=str2.length();
        int[][] dp=new int[len1+1][len2+1];
        int maxDistance=0;
        int lastIndex=0;
        for (int i = 1; i <=str1.length(); i++) {
            for (int j = 1; j <=str2.length(); j++) {
                if (str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if (maxDistance<dp[i][j]){
                        lastIndex=i-1;
                        maxDistance=dp[i][j];
                    }
                }
            }
        }
        if (maxDistance==0) {
            return "-1";
        }else {
            return str1.substring(lastIndex-maxDistance+1,lastIndex+1);
        }
    }
}
