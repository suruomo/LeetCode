package interview;

/**
 * @author: suruomo
 * @date: 2021/3/30 18:57
 * @description: 对于一个字符串，请设计一个高效算法，计算其中最长回文子串的长度。
 *
 * 给定字符串A以及它的长度n，请返回最长回文子串的长度。
 */
public class GetLongestPalindrome {
    public int getLongestPalindrome(String A, int n) {
        boolean[][] dp=new boolean[n][n];
        int maxLength=0;
        for (int len = 0; len < n; len++) {
            for (int i = 0; i+len< n; i++) {
                int j=i+len;
                if (len==0){
                    dp[i][j]=true;
                }else if(len==1){
                    dp[i][j]=A.charAt(i)==A.charAt(j);
                }else {
                    dp[i][j]=(A.charAt(i)==A.charAt(j))&&dp[i+1][j-1];
                }
                if (dp[i][j]&&len+1>maxLength){
                    maxLength=len+1;
                }
            }
        }
        return maxLength;
    }
}
