package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * @author: suruomo
 * @date: 2021/3/31 18:44
 * @description: 输入一个字符串,按字典序打印出该字符串中字符的所有排列
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        ArrayList<String> ans=new ArrayList<>();
        HashSet<String> set=new HashSet<>();
        backtrack(set,chars,0);
        ans.addAll(set);
        Collections.sort(ans);
        return ans;
    }
    private void backtrack(HashSet<String> ans, char[] chars,int index) {
        if (index== chars.length){
            ans.add(new String(chars));
            return;
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            backtrack(ans, chars,   index+1);
            swap(chars, i, index);
        }
    }

    private void swap(char[] chars, int i, int index) {
        char temp=chars[i];
        chars[i]=chars[index];
        chars[index]=temp;
    }
}
