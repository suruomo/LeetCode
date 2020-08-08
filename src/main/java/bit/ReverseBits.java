package bit;

/**
 * @author suruomo
 * @date 2020/8/8 14:23
 * @description: 190 颠倒给定的 32 位无符号整数的二进制位。
 */
public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) + (n & 1);
            n >>= 1;
        }
        return res;
    }
}
