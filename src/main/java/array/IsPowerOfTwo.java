package array;

/**
 * 问题231：给定一个整数，编写一个函数来判断它是否是 2 的幂次方。

 * @author 苏若墨
 */
public class IsPowerOfTwo {
    public static void main(String[] args) {
        int n=1024;
        System.out.println(isPowerOfTwo(n));
    }

    private static boolean isPowerOfTwo(int n) {
        if(n==0)
        {
            return false;
        }
        while (n%2==0){
            n=n/2;
        }
        return n==1;
    }
}
