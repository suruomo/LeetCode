package interview;

/**
 * @author: suruomo
 * @date: 2021/6/7 11:56
 * @description: 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
 * <p>
 * 现在给一串数字，返回有多少种可能的译码结果
 */
public class NumDecodings {
    public int solve(String nums) {
        int len = nums.length();
        // dp[i]表示前i个字符的编码总数
        int[] dp = new int[len + 1];
        dp[0] = 0;
        for (int i = 1; i <=len; i++) {
            if (nums.charAt(i-1)-'0'>0){
                dp[i]=dp[i-1];
            }
            if (i>1&&nums.charAt(i-2)-'0'>0&&((nums.charAt(i-2)-'0')*10+nums.charAt(i-1)-'0'<=26)){
                dp[i]+=dp[i-2];
            }
        }
        return dp[len];
    }
}
