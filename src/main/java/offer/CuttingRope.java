package offer;

/**
 * @author: suruomo
 * @date: 2021/1/4 11:38
 * @description: 剑指 Offer 14- I. 剪绳子
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 *
 */
public class CuttingRope {
    /**
     * 数学推导：
     * 推论一： 将绳子 以相等的长度等分为多段 ，得到的乘积最大。
     * 推论二： 尽可能将绳子以长度 3 等分为多段时，乘积最大。
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if(n <= 3) {
            return n - 1;
        }
        int a = n / 3, b = n % 3;
        // 1.完全分为3的等分段，剩余0
        if(b == 0) {
            return (int)Math.pow(3, a);
        }
        // 2.剩余1
        if(b == 1) {
            return (int)Math.pow(3, a - 1) * 4;
        }
        // 3.剩余2
        return (int)Math.pow(3, a) * 2;
    }
}
