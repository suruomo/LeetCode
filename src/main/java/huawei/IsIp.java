package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/18 16:15
 * @description:
 */
public class IsIp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String ip=sc.nextLine();
            if (isValid(ip)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isValid(String ip) {
        String[] strings=ip.split("\\.");
        int[] ips=new int[4];
        for (int i = 0; i < 4; i++) {
            ips[i]=Integer.valueOf(strings[i]);
            if (ips[i]<0||ips[i]>255){
                return false;
            }
        }
        return true;
    }
}
