package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 问题:找出一个字符串的不含重复字符的最大子串长度
 * 思路：滑动窗口
 * @author 苏若墨
 */
public class LengthOfLongestSubString {
    public static void main(String[] args) {
        String s="ckilbkd";
        System.out.println("不重复字符的最大子串长度是"+lengthOfLongestSubString(s));
    }

    private static int lengthOfLongestSubString(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
