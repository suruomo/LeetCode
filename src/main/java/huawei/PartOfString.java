package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/23 11:58
 * @description: 截取字符串前k个字符
 */
public class PartOfString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            int k=sc.nextInt();
            StringBuilder stringBuilder=new StringBuilder();
            for (int i = 0; i < k; i++) {
                stringBuilder.append(s.charAt(i));
            }
            System.out.println(stringBuilder.toString());
        }
    }

}
