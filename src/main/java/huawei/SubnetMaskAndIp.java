package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/18 14:43
 * @description:
 * 输入一个子网掩码以及两个ip地址，判断这两个ip地址是否是一个子网络。
 * 若IP地址或子网掩码格式非法则输出1，
 * 若IP1与IP2属于同一子网络输出0，
 * 若IP1与IP2不属于同一子网络输出2。
 */
public class SubnetMaskAndIp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String subnetMask=sc.nextLine();
            String ip1=sc.nextLine();
            String ip2=sc.nextLine();
            String[] a=subnetMask.split("\\.");
            String[] b=ip1.split("\\.");
            String[] c=ip2.split("\\.");
            // 判断是否合法
            if (!isMask(a)||!isIp(b)||!isIp(c)){
                System.out.println(1);
                continue;
            }
            boolean flag=true;
            for (int i = 0; i < 4; i++) {
                if ((Integer.valueOf(a[i])&Integer.valueOf(b[i]))!=(Integer.valueOf(a[i])&Integer.valueOf(c[i]))){
                    System.out.println(2);
                    flag=false;
                    break;
                }
            }
            if (flag){
                System.out.println(0);
            }
        }
    }

    private static boolean isIp(String[] b) {
        if (b.length!=4){
            return false;
        }
        int[] ips=new int[4];
        for (int i = 0; i < 4; i++) {
            ips[i]=Integer.valueOf(b[i]);
        }
        return ips[0]>=0&&ips[0]<=255&&
               ips[1]>=0&&ips[1]<=255&&
               ips[2]>=0&&ips[2]<=255&&
               ips[3]>=0&&ips[3]<=255;
    }

    private static boolean isMask(String[] a) {
        if (a.length!=4){
            return false;
        }
        int[] masks=new int[4];
        for (int i = 0; i < 4; i++) {
            masks[i]=Integer.valueOf(a[i]);
        }
        return masks[0]>=0&&masks[0]<=255&&
                masks[1]>=0&&masks[1]<=255&&
                masks[2]>=0&&masks[2]<=255&&
                masks[3]>=0&&masks[3]<=255&&
                masks[0]>=masks[1]&&masks[1]>=masks[2]&&masks[2]>=masks[3];
    }
}
