package interview;

/**
 * @Author: suruomo
 * @Date: 2021/7/15 13:47
 * @Description: 实现函数 int sqrt(int x).
 * 计算并返回x的平方根（向下取整）
 */
public class Sqrt {
    public int sqrt (int x) {
        if (x <= 0) {
            return 0;
        }
        int i = 1;
        for (i = 1; i <= x; i ++) {
            if (i * i <= x && (i + 1) * (i + 1) > x) {
                break;
            }
        }
        return i;
    }
}
