package backtracking;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: suruomo
 * @Date: 2021/7/15 16:06
 * @Description: 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 字符可重复
 */
public class PermuteUniqueString {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> strings=new ArrayList<>();
        permute(str.toCharArray(),strings,0);
        Collections.sort(strings);
        return strings;
    }

    /**
     * 回溯
     * @param chars
     * @param strings
     * @param index 当前索引
     */
    private void permute(char[] chars, ArrayList<String> strings, int index) {
        if(index==chars.length){
            String s=new String(chars);
            if (!strings.contains(s)){
                strings.add(s);
                return;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            swap(chars,i,index);
            permute(chars, strings, index+1);
            swap(chars,i,index);
        }
    }

    private void swap(char[] chars, int i, int index) {
        char temp=chars[i];
        chars[i]=chars[index];
        chars[index]=temp;
    }
}
