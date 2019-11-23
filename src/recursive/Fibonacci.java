package recursive;

/**
 * 斐波那契序列
 * @author 苏若墨
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacci(12));
    }

    private static int fibonacci(int n) {
        if(n==0||n==1){
            return n;
        }
        else{
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }
}
