package string;

/**
 *问题：验证回文字符串，只考虑数字和字母。不考虑大小写
 * @author 苏若墨
 */
public class IsPalindrome {
    public static void main(String[] args) {
        String s="a";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        if (s == null||"".equals(s)) {
            return true;
        }
        s = s.toLowerCase();
        int l = s.length();
        StringBuilder str = new StringBuilder(l);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }
}
