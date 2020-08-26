package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: suruomo
 * @Date: 2020/8/26 9:41
 * @Description:
 */
public class LetterCombinations {
    public static void main(String[] args) {
        //结果顺序：ad,ae,af,bd,be,bf,cd,ce,cf
        String digits="23";
        System.out.println(letterCombinations(digits));
    }

    private static List<String> letterCombinations(String digits) {
        List<String> combinations=new ArrayList<>();
        if(digits.length()==0){
            return combinations;
        }
        //电话号码
        Map<Character,String> phoneMap=new HashMap<Character, String>(8){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations,phoneMap,digits,0,new StringBuffer());
        return combinations;
    }

    /**
     * 回溯
     * @param combinations 结果集合
     * @param phoneMap 电话号码
     * @param digits 数字字符串
     * @param index digits的索引
     * @param combination 已有字母排列
     */
    private static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        //若当前索引等于号码字符串长度，则加入当前字母排列
        if (index==digits.length()){
            combinations.add(combination.toString());
        }else {
            //当前遍历数字字符
            char c=digits.charAt(index);
            //map查找当前数字对应字符序列
            String s=phoneMap.get(c);
            int count=s.length();
            //开始遍历
            for(int i=0;i<count;i++){
                //字母排列加入当前字符
                combination.append(s.charAt(i));
                //查找下一个索引的字母
                backtrack(combinations,phoneMap,digits,index+1,combination);
                //删除当前索引位置字母，重新进行排列
                combination.deleteCharAt(index);
            }
        }
    }
}
