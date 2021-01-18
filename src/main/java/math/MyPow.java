package math;

/**
 * @author: suruomo
 * @date: 2021/1/18 11:38
 * @description: 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class MyPow {
    public double myPow(double x, int n) {
        long N=n;
        return N>0?quickMul(x,N):1.0/quickMul(x,-N);
    }

    private double quickMul(double x, long N) {
        if (N==0){
            return 1.0;
        }
        double y=quickMul(x,N/2);
        return N%2==0?y*y:y*y*x;
    }
}
