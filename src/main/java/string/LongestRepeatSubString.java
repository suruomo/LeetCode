package string;

/**
 * @Author: suruomo
 * @Date: 2021/7/13 10:04
 * @Description:
 * 一个重复字符串是由两个相同的字符串首尾拼接而成，例如abcabc便是长度为6的一个重复字符串，而abcba则不存在重复字符串。
 * 给定一个字符串，请编写一个函数，返回其最长的重复字符子串。
 * 若不存在任何重复字符子串，则返回0。
 */
public class LongestRepeatSubString {
    public int solve (String a) {
        int n=a.length();
        int len=n/2;
        for (int i = n; i>0; i--) {
            for (int j = 0; j <=n-2*i; j++) {
                if (judge(a,j,i)){
                    return 2*i;
                }
            }
        }
        return 0;
    }

    /**
     * 判断当前字符串是否重复
     * @param a 字符串
     * @param j 起始位置
     * @param i 长度
     * @return
     */
    private boolean judge(String a, int j, int i) {
        for (int k = j; k <j+i; k++) {
            if (a.charAt(k)!=a.charAt(k+i)){
                return false;
            }
        }
        return true;
    }
}
