package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/24 11:48
 * @description: 挑选7
 * 7的倍数或者包含7
 */
public class SelectSeven {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int num=sc.nextInt();
            System.out.println(getCount(num));
        }
    }

    private static int getCount(int num) {
        int count=0;
        for (int i = 1; i <=num; i++) {
            if (i%7==0||hasSeven(i)){
                count++;
            }
        }
        return count;
    }

    private static boolean hasSeven(int num) {
        String s=String.valueOf(num);
        if (s.contains("7")){
            return true;
        }else {
            return false;
        }
    }
}
