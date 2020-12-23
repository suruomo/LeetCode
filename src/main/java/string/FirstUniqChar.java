package string;

import java.util.HashMap;

/**
 * @author: suruomo
 * @date: 2020/12/23 10:35
 * @description: 387. 字符串中的第一个唯一字符
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
