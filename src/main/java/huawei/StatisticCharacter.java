package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/18 15:47
 * @description:
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。
 *
 * 本题包含多组输入。
 */
public class StatisticCharacter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int number = sc.nextInt();
            String binaryString = Integer.toBinaryString(number);
            //再将字符串按多个0分割
            String[] strings = binaryString.split("0+");
            int count = 0;
            for (String string : strings) {
                count = Math.max(count, string.length());
            }
            System.out.println(count);
        }
    }
}
