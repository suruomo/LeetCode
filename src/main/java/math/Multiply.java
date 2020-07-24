package math;

/**
 * @author suruomo
 * @date 2020/7/24 16:28
 * @description: 递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。
 * 可以使用加号、减号、位移，但要吝啬一些。
 * 注意不要溢出
 */
public class Multiply {
    public static void main(String[] args) {
        int A=3;
        int B=4;
        System.out.println(multiply(A,B));
    }

    private static int multiply(int A, int B) {
        if (A > B) {
            return multiply(B, A);
        }
        if (A == 0) {
            return 0;
        }
        return B + multiply(A - 1, B);
    }


}
