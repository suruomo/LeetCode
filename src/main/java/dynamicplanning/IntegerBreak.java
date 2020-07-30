package dynamicplanning;

/**
 * @author suruomo
 * @date 2020/7/30 15:36
 * @description: 343 给定一个正整数 n，将其拆分为至少两个正整数的和，
 * 并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 */
public class IntegerBreak {
    public static void main(String[] args) {
        int n=10;
        System.out.println(integerBreak(n));
    }

    private static int integerBreak(int n) {
        //dp[i]表示表示整数i可以被拆分获得的最大乘积；
        int[] dp=new int[n+1];
        //0不是正整数，1无法被拆分，所以为0；
        dp[0]=dp[1]=0;
        for (int i=2;i<=n;i++){
            // 记录dp[i]最大值；
            int max=0;
            // j表示可以每个整数i可以被拆分的值；
            // 将 i 拆分成 jj和 i−j 的和，且 i−j 不再拆分成多个正整数，此时的乘积是 j×(i−j)
            // 将 i拆分成 j 和 i-j的和，且 i−j 继续拆分成多个正整数，此时的乘积是j×dp[i−j]。
            for (int j=1;j<i;j++){
                max=Math.max(max,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i]=max;
        }
        return dp[n];
    }
}
