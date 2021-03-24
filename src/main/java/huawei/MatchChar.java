package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/24 15:53
 * @description:
 * 字符串通配符匹配
 * *匹配0或者多个
 * ？匹配一个
 */
public class MatchChar {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String regx=sc.nextLine();
            String s=sc.nextLine();
            System.out.println(matchChar(regx,s));
        }
    }

    private static boolean matchChar(String regx, String s) {
        regx=regx.replaceAll("\\?","[0-9a-zA-Z]{1}");
        regx=regx.replaceAll("\\*","[0-9a-zA-Z]{0,}");
        return s.matches(regx);
    }
}
