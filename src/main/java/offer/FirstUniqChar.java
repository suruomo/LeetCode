package offer;

import java.util.HashMap;

/**
 * @author: suruomo
 * @date: 2020/12/3 15:05
 * @description: 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> dic = new HashMap<>();
        char[] sc = s.toCharArray();
        // 存
        for(char c : sc) {
            dic.put(c, !dic.containsKey(c));
        }
        // 遍历，返回第一个为true的字符
        for(char c : sc) {
            if(dic.get(c)) {
                return c;
            }
        }
        return ' ';
    }
}
