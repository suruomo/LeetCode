package string;

/**
 * @Author: suruomo
 * @Date: 2020/9/14 9:24
 * @Description: 剑指offer 05 替换空格
 * 将字符串中的空格替换为%20
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    private static String replaceSpace(String s) {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == ' '){
                string.append("%20");
            } else {
                string.append(c);
            }

        }
        return string.toString();
    }
}
