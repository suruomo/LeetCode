package bit;

/**
 * @author suruomo
 * @date 2020/7/15 15:37
 * @description: 191 编写一个函数，输入是一个无符号整数，
 * 返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class HammingWeight {
    public int hammingWeight(int n) {
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
}
