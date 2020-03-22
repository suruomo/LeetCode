package string;

/**
 *问题：给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * @author 苏若墨
 */
public class IsSubsequence {
    public static void main(String[] args) {
        String s="abc";
        String t="gjabckj";
        System.out.println(isSubsequence(s,t));
    }

    /**
     * 双指针法
     * @param s
     * @param t
     * @return
     */
    private static boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int m = s.length(), n = t.length();
        while(i < m && j < n){
//            两个指针一起比较
            if(s.charAt(i)== t.charAt(j)){
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        return i == m;
    }
}
