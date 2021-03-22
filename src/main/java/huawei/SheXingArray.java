package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/22 16:47
 * @description:
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 *
 * 例如，当输入5时，应该输出的三角形为：
 *
 * 1 3 6 10 15
 *
 * 2 5 9 14
 *
 * 4 8 13
 *
 * 7 12
 *
 * 11
 */
public class SheXingArray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int num=sc.nextInt();
            // 每行第一个数
            int y=1;
            // 每行第一个数之间差值，第一行与第二行差1
            int ycount=1;
            // 1.行循环
            for (int i = 0; i < num; i++) {
                // 第一个数
                int x=y;
                // 各列之间差值
                int xcount=i+2;
                // 2.列循环
                for (int j = 0; j <num-i ; j++) {
                    System.out.print(x+" ");
                    x+=xcount++;
                }
                System.out.println("");
                y+=ycount++;
            }
        }
    }
}
