package interview;

import java.util.Arrays;

/**
 * @author: suruomo
 * @date: 2021/4/26 10:40
 * @description: 字符串的最长公共前缀
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix (String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        Arrays.sort(strs);
        int len= strs.length;
        int minLength=Math.min(strs[0].length(), strs[len-1].length());
        String s0=strs[0];
        String s1=strs[len-1];
        int i=0;
        for (i=0; i < minLength; i++) {
            if (s0.charAt(i)!=s1.charAt(i)){
                break;
            }
        }
        return s0.substring(0,i);
    }
}
