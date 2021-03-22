package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/22 13:26
 * @description: 整数与IP地址之间的相互转换
 * 输入描述:
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 *
 * 输出描述:
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 */
public class IntegerToIp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String ip=sc.nextLine();
            String num=sc.nextLine();
            System.out.println(toInteger(ip));
            System.out.println(toIp(num));
        }
    }

    /**
     * 十进制转换成ip地址
     * @param num
     * @return
     */
    private static String toIp(String num) {
        int len = num.length();
        // 转为二进制
        String binaryString=Long.toBinaryString(Long.parseLong(num));
        StringBuilder sb = new StringBuilder(binaryString);
        // 不足32位的前面补0
       while (sb.length()<32){
           sb.insert(0,0);
       }
        System.out.println(binaryString);
        String fin = sb.toString();
        long a = Long.valueOf(fin.substring(0, 8), 2);
        long b = Long.valueOf(fin.substring(8, 16), 2);
        long c = Long.valueOf(fin.substring(16, 24), 2);
        long d = Long.valueOf(fin.substring(24, 32), 2);
        return a + "." + b + "." + c + "." + d;
    }

    /**
     * ip转化成十进制
     * @param ip
     * @return
     */
    private static Long toInteger(String ip) {
        StringBuilder stringBuilder=new StringBuilder();
        String[] strings=ip.split("\\.");
        for (int i = 0; i < 4; i++) {
            // 转为二进制字符串
            String s1=Long.toBinaryString(Long.parseLong(strings[i]));
            // 不满8位补0
            s1=String.format("%08d",Long.parseLong(s1));
            stringBuilder.append(s1);
        }
        // 二进制转10进制
        return Long.parseLong(stringBuilder.toString(),2);
    }
}
