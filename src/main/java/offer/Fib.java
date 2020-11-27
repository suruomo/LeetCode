package offer;

/**
 * @author: suruomo
 * @date: 2020/11/27 15:16
 * @description: 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 */
public class Fib {
    /**
     * 递归版本
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n==0||n==1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }

    /**
     * 非递归版本
     * @param n
     * @return
     */
    public int fib1(int n) {
        int constant = 1000000007;
        int first = 0;
        int second = 1;
        while (n-- > 0) {
            int temp = first + second;
            first = second % constant;
            second = temp % constant;
        }
        return first;
    }

    /**
     * 动态规划版本
     * @param n
     * @return
     */
    public int fib2(int n){
        if(n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }

}
