package string;

/**
 * @author: suruomo
 * @date: 2020/10/19 9:46
 * @description: 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 */
public class BackSpaceCompare {
    public static void main(String[] args) {
        String S="a#c";
        String T="ad#c";
        System.out.println(backSpaceCompare(S,T));
    }

    private static boolean backSpaceCompare(String S, String T) {
        return backString(S).equals(backString(T));
    }

    private static String backString(String s) {
        if (s.equals("")||s.equals("#")){
            return "";
        }
        StringBuffer t=new StringBuffer();
        int n=s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i)!='#'){
                t.append(s.charAt(i));
            }
            else{
                if (t.length() > 0) {
                    t.deleteCharAt(t.length() - 1);
                }
            }
        }
        return String.valueOf(t);
    }
}
