package string;

/**
 * @Author: suruomo
 * @Date: 2020/9/10 10:24
 * @Description: 剑指offer 58-2 左旋转字符串
 */
public class ReverseLeftWords {
    public static void main(String[] args) {
        String s="abcdefg";
        int n=2;
        System.out.println(reverseLeftWords(s,n));
    }

    /**
     * 字符串切片拼接
     * @param s
     * @param n
     * @return
     */
    private static String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
