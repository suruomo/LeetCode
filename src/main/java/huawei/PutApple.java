package huawei;


import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/24 13:10
 * @description:
 * 题目描述
 *
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？
 * （用K表示）5，1，1和1，5，1 是同一种分法。
 *
 * 数据范围：0<=m<=10，1<=n<=10。
 * 本题含有多组样例输入。
 */
public class PutApple {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int m=Integer.valueOf(sc.next());
            int n=Integer.valueOf(sc.next());
            System.out.println(count(m,n));
        }
    }

    private static int count(int m, int n) {
        if (m<0||n<0){
            return 0;
        }
        if (m==1||n==1){
            return 1;
        }
        // 两种情况
        // 1.有至少一个盘子为空
        // 2.每个盘子都不为空，每个盘子至少放了一个苹果
        return count(m,n-1)+count(m-n,n);
    }

}
