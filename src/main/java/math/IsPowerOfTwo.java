package math;

/**
 * @author suruomo
 * @date 2020/7/30 15:56
 * @description: 231 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class IsPowerOfTwo {
    public static void main(String[] args) {
        int n=218;
        System.out.println(isPowerOfTwo(n));
    }

    private static boolean isPowerOfTwo(int n) {
        if (n==1){
            return true;
        }
        if (n==0){
            return false;
        }
        while (n%2==0){
            n=n/2;
        }
        return n==1;
    }
}

