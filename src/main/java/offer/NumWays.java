package offer;

/**
 * @Author: suruomo
 * @Date: 2020/9/2 18:47
 * @Description: 10-11 青蛙跳台阶问题
 */
public class NumWays {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(numWays(n));
    }

    private static int numWays(int n) {
        if(n<=1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int a=1;
        int b=2;
        int res=0;
        for (int i = 3; i <=n; i++) {
            res=a+b;
            a=b;
            b=res;
        }
        return res;
    }
}
