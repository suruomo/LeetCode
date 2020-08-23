package bit;

/**
 * @Author: suruomo
 * @Date: 2020/8/23 16:33
 * @Description: 461 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 */
public class HammingDistance {
    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        System.out.println(hammingDistance(x,y));
    }

    /**
     * 方法一：使用内置计数器
     * @param x
     * @param y
     * @return
     */
    private static int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * 方法二:异或操作后手动计数
     * @param x
     * @param y
     * @return
     */
    private static int hammingDistance1(int x,int y){
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            //和1进行与操作可判断最右位置是不是1
            if ((xor&1)==1) {
                distance += 1;
            }
            //右移一位
            xor = xor >> 1;
        }
        return distance;
    }
}
