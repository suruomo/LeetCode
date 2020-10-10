package string;


import java.util.Collections;
import java.util.LinkedList;

/**
 * @author: suruomo
 * @date: 2020/10/10 10:19
 * @description: 394 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 *
 *
 * 注意：存在嵌套！！！
 */
public class DecodeString {
    /**
     * 指向当前遍历位置
     */
    static int ptr;

    public static void main(String[] args) {
        String s="3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    /**
     * 解码：栈原理，使用不定长数组linkedlist代替
     * 1.如果当前的字符为数位，解析出一个数字（连续的多个数位）并进栈
     * 2.如果当前的字符为字母或者左括号，直接进栈
     * 3.如果当前的字符为右括号，开始出栈，一直到左括号出栈，出栈序列反转后拼接成一个字符串，
     * 此时取出栈顶的数字，就是这个字符串应该出现的次数，根据这个次数和字符串构造出新的字符串并进栈
     * @param s
     * @return
     */
    private static String decodeString(String s) {
        LinkedList<String> stk=new LinkedList<>();
        ptr=0;
        while (ptr<s.length()){
            // 取出栈顶当前字符
            char cur=s.charAt(ptr);
            // 1.当前字符是数字
            if(Character.isDigit(cur)){
                String digits=getDigits(s);
                stk.addLast(digits);
            }
            // 2.当前字符是字符
            else if(Character.isLetter(cur)||cur=='['){
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            }
            // 3.当前字符是右括号，执行出栈
            else{
                ptr++;
                LinkedList<String> sub=new LinkedList<>();
                while (!"[".equals(stk.peekLast())){
                    sub.addLast(stk.removeLast());
                }
                // 翻转字符串
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 次数
                int repTime=Integer.parseInt(stk.removeLast());
                StringBuffer t=new StringBuffer();
                String o=getString(sub);
                // 根据次数repTime构造字符串
                while (repTime-->0){
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }
        return getString(stk);
    }

    private static String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    /**
     * 从linkelist转换为最终string
     * @param stk
     * @return
     */
    private static String getString(LinkedList<String> stk) {
        StringBuffer s=new StringBuffer();
        for (String v:stk){
            s.append(v);
        }
        return s.toString();
    }
}
