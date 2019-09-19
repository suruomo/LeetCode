package sort;

import java.util.Arrays;

/**
 * @author 苏若墨
 */
public class VaildAnagram {
    public static void main(String[] args) {
        String s="anagram";
        String t="nagaram";
        System.out.println(isAnagram(s,t));
        System.out.println(hashAnagram(s,t));
    }

    /**
     * 排序
     * @param s
     * @param t
     * @return
     */
    private static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] chars=s.toCharArray();
        char[] chars1=t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        return Arrays.equals(chars, chars1);
    }

    /**
     * 哈希法：用一个计数器表计算 s 字母的频率，用 t减少计数器表中的每个字母的计数器，然后检查计数器是否回到零。
     * @param s
     * @param t
     * @return
     */
    private static boolean hashAnagram(String s,String t){
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            //当前字母计数不为0，返回false
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
