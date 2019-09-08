package factorial;

/**
 * @author 苏若墨
 * 问题：求阶乘最后有几个零
 */
public class FactorialTrailingZeroes {
    public static void main(String[] args) {
        int num=3;
        System.out.println(findZeros(num));
    }

    private static int findZeros(int n) {
        int b = 0;
        while (n >= 5) {
            b += n / 5;
            n /= 5;
        }
        return b;
    }
}
