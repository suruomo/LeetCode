package offer;

/**
 * @author: suruomo
 * @date: 2020/12/18 11:37
 * @description: 剑指 Offer 58 - I. 翻转单词顺序
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。
 * 例如输入字符串"I am a student. "，则输出"student. a am I"。
 *
 */
public class ReverseWords {
    /**
     * 双指针法
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        int j=s.length()-1,i=j;
        StringBuilder res=new StringBuilder();
        while (i>=0){
            // 寻找单词左边界
            while (i>=0&&s.charAt(i)!=' '){
                i--;
            }
            // 添加单词
            res.append(s.substring(i+1,j+1)+" ");
            // 跳过空格
            while (i>=0&&s.charAt(i)==' '){
                i--;
            }
            // 让j指向单词右边界
            j=i;
        }
        return res.toString().trim();
    }

    /**
     * 利用切割函数，面试不建议使用
     * @param s
     * @return
     */
    public String reverseWords1(String s) {
        String[] strs=s.trim().split(" ");
        StringBuilder res=new StringBuilder();
        for (int i = strs.length-1; i>=0; i--) {
            if (strs[i].equals("")){
                continue;
            }
            res.append(strs[i]+" ");
        }
        return res.toString().trim();
    }
}
