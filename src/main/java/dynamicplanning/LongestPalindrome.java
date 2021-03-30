package dynamicplanning;

/**
 * @author: suruomo
 * @date: 2021/3/30 18:52
 * @description: 5. 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 */
public class LongestPalindrome {
    public String longestPalindrome(String s) {
        int n = s.length();
        // dp[i][j]表示下标i~j之间的字符串是不是回文串
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        //  遍历所有长度
        for(int len = 0; len < s.length() ; len ++){
            //从start开始的len长度
            for (int start = 0; start < dp.length - len; start++) {
                int end = start + len;
                if(len == 0) {
                    dp[start][end] = true;
                } else if(len == 1) {
                    dp[start][end] = s.charAt(start) == s.charAt(end);
                } else {
                    dp[start][end] = s.charAt(start) == s.charAt(end) && dp[start + 1][end - 1];
                }
                if(dp[start][end] && len >= ans.length()){
                    ans = s.substring(start, end + 1);
                }

            }
        }
        return ans;
    }
}
