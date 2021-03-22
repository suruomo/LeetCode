package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/22 10:37
 * @description: 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，
 * 设计一个算法，求输入A和B的最小公倍数。
 */
public class LeastCommonMultiple {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int a= sc.nextInt();
            int b=sc.nextInt();
            System.out.println(a*b/gcd(a,b));
        }
    }

    private static int gcd(int a, int b) {
        // 保证a>b
        if (a<b){
            int t=a;
            a=b;
            b=t;
        }
        if (a%b==0){
            return b;
        }
        // 辗转相除法
        while (b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}
