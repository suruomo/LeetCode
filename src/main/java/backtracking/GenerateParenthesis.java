package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2020/9/15 11:14
 * @description: 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class GenerateParenthesis {
    /**
     *
     * @param n 生成括号对数
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    /**
     * 回溯
     * @param ans 结果集
     * @param cur 当前生成括号组合字符串
     * @param open 左括号个数
     * @param close 右括号个数
     * @param max 对数（每种括号最大个数）
     */
    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max){
        //结束条件
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }
        //左括号不够时
        if (open < max) {
            //选择
            cur.append('(');
            //下一层回溯
            backtrack(ans, cur, open+1, close, max);
            //取消选择
            cur.deleteCharAt(cur.length() - 1);
        }
        //右括号不够时
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close+1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}
