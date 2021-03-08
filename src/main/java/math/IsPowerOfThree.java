package math;

/**
 * @author suruomo
 * @date 2020/7/29 15:43
 * @description: 326. 3的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 */
public class IsPowerOfThree {
    public static void main(String[] args) {
        int n=45;
        System.out.println(isPowerOfThree(n));
    }

    private static boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n%3==0){
            n=n/3;
        }
        return n==1;
    }
}
