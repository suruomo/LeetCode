package backtracking;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2021/1/18 12:00
 * @description: 131. 分割回文串
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 */
public class Partition {
    public List<List<String>> partition(String s) {
        int len=s.length();
        // 结果集
        List<List<String>> res=new ArrayList<>();
        if (len==0){
            return res;
        }
        // 搜索路径
        Deque<String> path=new ArrayDeque<>();
        backtrack(s,0,len,path,res);
        return res;
    }

    /**
     * 回溯
     * @param s 字符串
     * @param start 开始搜索索引
     * @param len 字符串总长度
     * @param path 搜索路径
     * @param res 结果集
     */
    private void backtrack(String s, int start, int len, Deque<String> path, List<List<String>> res) {
        // 终止条件：字符串遍历完全
        if (start==len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            if (!isPalindrome(s,start,i)){
                continue;
            }
            path.addLast(s.substring(start,i+1));
            backtrack(s, i+1, len, path, res);
            path.removeLast();
        }
    }

    /**
     * 判断是否是回文字符串
     * @param s 字符串
     * @param start 开始索引
     * @param end 结束索引
     * @return
     */
    private boolean isPalindrome(String s, int start, int end) {
        while (start<end){
            if (s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
