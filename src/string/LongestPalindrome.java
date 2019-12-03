package string;

/**
 * 问题：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 思路：动态规划
 * P(i,j)=true s[i,j]是回文串
 *       false s[i,j]不是回文串
 *
 *P(i,j)=(P(i+1,j−1)&&S[i]==S[j])
 *
 *递推公式中我们可以看到，我们首先知道了 i +1才会知道 i ，所以我们只需要倒着遍历就行了。
 * @author 苏若墨
 */
public class LongestPalindrome {
    public static void main(String[] args) {
        String s="babad";
        System.out.println("最大回文子串是："+longestPalindrome(s));
    }

    private static String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                //j - i + 1 代表字符串长度，当字符串长度为0，1，2时且s[i]==s[j]即为回文子串
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i +1< 3 || dp[i + 1][j - 1]);
                if (dp[i][j] &&  j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }
}

