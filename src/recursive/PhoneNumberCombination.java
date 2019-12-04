package recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 问题：给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * @author 苏若墨
 */
public class PhoneNumberCombination {

    private static HashMap<Integer, String> map;
    private static ArrayList<String> res;

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    /**
     * 返回字母组合List
     * @param digits 待组合电话号码
     * @return
     */
    public static List<String> letterCombinations(String digits) {
        map = new HashMap();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        res = new ArrayList<String>();
        if (digits.equals("")) {
            return res;
        }
        findCombination(digits, 0, "");
        return res;
    }

    /**
     * 递归查找组合情况
     * @param digits 查找数字串
     * @param index 当前查找数字串索引
     * @param s 当前字符串组合
     */
    private static void findCombination(String digits, int index, String s) {
        //当一种字符串找到时，加入list，回溯
        if (index == digits.length()) {
            res.add(s);
            return;
        }
        //当前查找数字
        Integer c = Integer.parseInt(String.valueOf(digits.charAt(index)));
        //查找当前数字所代表字符串
        String letters = map.get(c);
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, s + letters.charAt(i));
        }
        return;
    }


}
