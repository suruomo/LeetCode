package dynamicplanning;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: suruomo
 * @date: 2020/11/11 12:54
 * @description: 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，
 * 判定s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet(wordDict);
        // dp[i] 表示字符串 s 前 i 个字符组成的字符串s[0..i−1] 是否能被空格拆分成若干个字典中出现的单词
        boolean[] dp=new boolean[s.length()+1];
        dp[0]=true;
        for (int i = 1; i <=s.length(); i++) {
            // 枚举s[0..i−1] 中的分割点 j,看前后两个字符串是否合法
            for (int j = 0; j < i; j++) {
                if(dp[j]&&set.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }

            }
        }
        return dp[s.length()];
    }
}
