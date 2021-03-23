package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/23 11:32
 * @description: 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 *
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 */
public class PiaoLiang {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=Integer.valueOf(sc.next());
            for (int i = 0; i < n; i++) {
                String s=sc.next().toLowerCase();
                System.out.println(get(s));
            }
        }
    }

    private static int get(String s) {
        // 记录每个字符出现次数
        int[] chars=new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)-'a']++;
        }
        // 排序
        Arrays.sort(chars);
        int count=0;
        for (int weight=26,i=25;i>=0;i--){
            if (chars[i]!=0){
                count+=weight*chars[i];
                weight--;
            }
        }
        return count;
    }
}
