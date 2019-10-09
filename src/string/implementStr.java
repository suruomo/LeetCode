package string;

/**
 * 问题：实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
 * 如果不存在，则返回  -1。
 *
 * @author 苏若墨
 */
public class implementStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        strStr(haystack, needle);
    }

    private static int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        } else {
            return -1;
        }
    }
}
