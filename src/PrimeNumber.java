import java.util.Scanner;

/**
 * @author 苏若墨
 * 问题：找出2~10000的素数（一个大于等于2的数，除了1和它本身，再没有其他的整数能将其整除的数叫素数）
 */
public class PrimeNumber {
    public static void main(String[] args) {
        int n=10000;
        findPrimeNUmber(n);
    }

    private static void findPrimeNUmber(int n) {
        int j=1;
        boolean flag;
        for(int i=2;i<n;i++){
            flag=true;
            for(j=2;j<=Math.sqrt(i);j++){
                if(i%j==0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println(i);
            }
        }
    }
}
