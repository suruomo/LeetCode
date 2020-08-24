package string;

/**
 * @Author: suruomo
 * @Date: 2020/8/24 15:41
 * @Description: 459 给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。
 * 给定的字符串只含有小写英文字母，并且长度不超过10000。
 */
public class RepeatedSubStringPattern {
    public static void main(String[] args) {
        String s = "abab";
        System.out.println(repeatedSubstringPattern(s));
    }

    private static boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
