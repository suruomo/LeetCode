package array;

import java.util.*;

/**
 * @author: suruomo
 * @date: 2020/11/10 10:16
 * @description: 49. 字母异位词分组
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs==null){
            return new ArrayList<>();
        }
        Map<String,List> map=new HashMap<>();
        for (String str:strs){
            char[] c=str.toCharArray();
            Arrays.sort(c);
            String s=String.valueOf(c);
            if (!map.containsKey(s)){
                map.put(s,new ArrayList());
            }
            map.get(s).add(str);
        }
        return new ArrayList(map.values());
    }
}
