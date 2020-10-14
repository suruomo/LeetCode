package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2020/10/14 17:12
 * @description: 1002 查找常用字符
 *给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 */
public class CommonChars {
    public List<String> commonChars(String[] A) {
        // 存储字符 c 在所有字符串中出现次数的最小值 x
        // 则最终结果中添加x次字符c
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word: A) {
            int[] freq = new int[26];
            int length = word.length();
            // 遍历当前字符串，找出每种字符的出现次数
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            // 将每一个minfreq[c] 更新为其本身与freq[c] 的较小值
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            // 当前字符出现几次，则向结果集中添加几次
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}
