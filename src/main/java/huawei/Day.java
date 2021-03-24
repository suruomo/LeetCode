package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/24 16:27
 * @description:
 */
public class Day {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int year=Integer.valueOf(sc.next());
            int month=Integer.valueOf(sc.next());
            int day=Integer.valueOf(sc.next());
            System.out.println(getResult(year,month,day));
        }
    }

    private static int getResult(int year, int month, int day) {
        int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
        int sum=0;
        for (int i = 0; i < month-1; i++) {
            sum+=days[i];
        }
        sum+=day;
        if(month>2&&isLeap(year)){
            sum++;
        }
        return sum;
    }

    private static boolean isLeap(int year) {
        if ((year%4==0&&year%100!=0)||(year%400==0)){
            return true;
        }
        return false;
    }
}
