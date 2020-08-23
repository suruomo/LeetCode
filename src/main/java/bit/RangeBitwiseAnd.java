package bit;

/**
 * @Author: suruomo
 * @Date: 2020/8/23 15:59
 * @Description: 201. 数字范围按位与
 * 给定范围 [m, n]，其中 0 <= m <= n <= 2147483647，返回此范围内所有数字的按位与（包含 m, n 两端点）。
 */
public class RangeBitwiseAnd {
    public static void main(String[] args) {
        int m=5;
        int n=7;
        System.out.println(rangeBitwiseAnd(m,n));
    }

    /**
     * 可以将问题重新表述为：给定两个整数，我们要找到它们对应的二进制字符串的公共前缀。
     * @param m
     * @param n
     * @return
     */
    public static int rangeBitwiseAnd(int m,int n){
        //右移操作数
        int shift = 0;
        // 找到公共前缀
        while (m < n) {
            m >>= 1;
            n >>= 1;
            ++shift;
        }
        return m << shift;
    }

}
