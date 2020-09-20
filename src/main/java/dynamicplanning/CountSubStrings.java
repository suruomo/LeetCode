package dynamicplanning;

/**
 * @author: suruomo
 * @date: 2020/9/20 18:41
 * @description: 647 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class CountSubStrings {
    public static void main(String[] args) {
        String s="abc";
        System.out.println(countSubStrings(s));
    }

    /**
     * 状态：dp[i][j] 表示字符串s在[i,j]区间的子串是否是一个回文串。
     *
     * 状态转移方程：当 s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1]) 时，
     * dp[i][j]=true，否则为false
     * @param s
     * @return
     */
    private static int countSubStrings(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        int ans=0;
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <=j; j++) {
                if ((s.charAt(i)==s.charAt(j))&&(j-i<2||dp[i+1][j-1])){
                    dp[i][j]=true;
                    ans++;
                }
            }
            
        }
        return ans;
    }
}
