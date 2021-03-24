package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/24 11:24
 * @description: Levenshtein 距离，又称编辑距离，
 * 指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。
 * 许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。
 * Ex：
 * 字符串A:abcdefg
 *
 * 字符串B: abcdef
 *
 * 通过增加或是删掉字符”g”的方式达到目的。这两种方案都需要一次操作。
 * 把这个操作所需要的次数定义为两个字符串的距离。
 *
 * 要求：
 * 给定任意两个字符串，写出一个算法计算它们的编辑距离。
 */
public class Levenshtein {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String a=sc.nextLine();
            String b=sc.nextLine();
            System.out.println(getDistance(a,b));
        }
    }

    private static int getDistance(String a, String b) {
        // dp[i][j] 表示a中前i个字符和b中前j个字符的编辑距离
        int[][] dp=new int[a.length()+1][b.length()+1];
        // 初始化
        for (int i = 0; i <=a.length(); i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <=b.length(); i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <=a.length(); i++) {
            for (int j = 1; j <=b.length(); j++) {
                if (a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]+1);
                }
            }
        }
        return dp[a.length()][b.length()];
    }
}
