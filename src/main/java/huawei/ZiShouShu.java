package huawei;

import java.util.Scanner;

/**
 * @Author: suruomo
 * @Date: 2021/6/29 9:42
 * @Description: 自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数
 */
public class ZiShouShu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int selfHoldNumber = 0;
            for (int i = 0; i <= n; i++) {
                if (((int) Math.pow(i, 2) + "").matches("[0-9]*" + i + "$")) {
                    selfHoldNumber++;
                }
            }
            System.out.println(selfHoldNumber);
        }
    }
}
