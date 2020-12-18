package string;

import java.util.Arrays;

/**
 * @author: suruomo
 * @date: 2020/12/18 11:18
 * @description: 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char[] s1=s.toCharArray();
        char[] t1=t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        for (int i = 0; i < s1.length; i++) {
            if (t1[i]!=s1[i]){
                return t1[i];
            }
        }
        return t1[t1.length-1];
    }
}
