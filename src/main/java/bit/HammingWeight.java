package bit;

/**
 * @author suruomo
 * @date 2020/7/15 15:37
 * @description: 191 编写一个函数，输入是一个无符号整数，
 * 返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明权重）。
 */
public class HammingWeight {
    public static void main(String[] args) {
        int n=3;
        System.out.println(hammingWeight(n));
    }

    /**
     * 普通法1
     * 运算次数与输入n最高位1的位置有关，最多循环32次
     * @param n
     * @return
     */
    public static int hammingWeight(int n) {
        //计数器
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            //每一位和掩码1做与运算，结果不为0，则计数器加一
            if ((n & mask) != 0) {
                bits++;
            }
            //掩码左移一位
            mask <<= 1;
        }
        return bits;
    }
    /**
     * 普通法2
     * @param n
     * @return
     */
    public static int hammingWeight1(int n) {
        //计数器
        int bits = 0;
        while (n>0){
            if ((n&1)==1){
                bits++;
            }
            n>>=1;
        }
        return bits;
    }
    /**
     * 普通法3
     * @param n
     * @return
     */
    public static int hammingWeight2(int n) {
        //计数器
        int bits = 0;
        for (bits=0;n>0; n>>=1) {
            bits+=(n&1);
        }
        return bits;
    }
    /**
     * 快速法
     * 运算次数与n中1个数有关
     * 原理是不断清除n的二进制表示中最右边的1，同时累加计数器，直至n为0
     * @param n
     * @return
     */
    public static int count(int n) {
        //计数器
        int bits = 0;
        for (bits=0;n>0; ++bits) {
           n&=(n-1);
        }
        return bits;
    }
}
