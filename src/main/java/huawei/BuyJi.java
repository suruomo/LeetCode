package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/24 16:00
 * @description:
 * 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：
 * 鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？
 */
public class BuyJi {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for (int i = 0; i <=20; i++) {
            for (int j = 0; j <=33; j++) {
                for (int k = 0; k <=300; k++) {
                    if (i+j+k==100&&i*15+j*9+k==300){
                        System.out.println(i+" "+j+" "+k);
                    }
                }
            }
        }
    }
}
