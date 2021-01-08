package string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2021/1/8 11:20
 * @description: 151. 翻转字符串里的单词
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 */
public class ReverseWords {
    public String reverseWords(String s) {
        // 去除字符串前后多余空格
        s=s.trim();
        // "\\s+"为正则表达，删除多余空格
        List<String> list= Arrays.asList(s.split("\\s+"));
        // 翻转字符串列表
        Collections.reverse(list);
        // 拼接字符串返回
        return String.join(" ", list);
    }
}
