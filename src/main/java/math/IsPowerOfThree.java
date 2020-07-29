package math;

/**
 * @author suruomo
 * @date 2020/7/29 15:43
 * @description:
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
