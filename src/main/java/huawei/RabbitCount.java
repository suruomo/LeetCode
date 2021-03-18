package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/18 14:19
 * @description:
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，
 * 假如兔子都不死，问每个月的兔子总数为多少？
 * 输入数据为月份
 */
public class RabbitCount {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int month=sc.nextInt();
            System.out.println(count(month));
        }
    }

    private static int count(int month) {
        int dp0=1;
        int dp1=1;
        for (int i = 2; i < month; i++) {
            int temp=dp1;
            dp1=dp0+dp1;
            dp0=temp;
        }
        return dp1;
    }
}
