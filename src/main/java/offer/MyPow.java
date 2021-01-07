package offer;

/**
 * @author: suruomo
 * @date: 2021/1/7 11:30
 * @description: 剑指 Offer 16. 数值的整数次方
 * 实现函数double Power(double base, int exponent)，
 * 求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 */
public class MyPow {
    public double myPow(double x, int n) {
        //如果n等于0，直接返回1
        if (n == 0) {
            return 1;
        }
        //如果n小于0，把它改为正数
        if (n < 0) {
            return 1 / x*myPow(1 / x, -n-1);
        }
        // n>0时根据n是奇数还是偶数来做不同的处理
        return (n % 2 == 0) ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
