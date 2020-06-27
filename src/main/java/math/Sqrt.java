package math;

/**
 * 问题69：实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * 思路：二分查找
 * 二分查找的下界为 00，上界可以粗略地设定为 xx。在二分查找的每一步中，我们只需要比较中间元素 \textit{mid}mid 的平方与 xx 的大小关系，并通过比较的结果调整上下界的范围。
 * 由于我们所有的运算都是整数运算，不会存在误差，因此在得到最终的答案 \ans 后，也就不需要再去尝试 ans+1 了。
 * @author 苏若墨
 */
public class Sqrt {
    public static void main(String[] args) {
        int x=9;
        System.out.println(mySqrt(x));
    }

    private static int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        //二分查找
        while (l <= r) {
            int mid = (l + r )/ 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
