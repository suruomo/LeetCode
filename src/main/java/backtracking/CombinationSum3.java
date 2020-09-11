package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: suruomo
 * @Date: 2020/9/11 9:52
 * @Description: 216 组合总和3
 * 找出所有相加之和为 n 的 k 个数的组合。
 * 组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 */
public class CombinationSum3 {
    public static void main(String[] args) {
        int k=3;
        int n=7;
        System.out.println(combinationSum3(k,n));
    }

    private static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        backtrack(k,n,1,ans,path);
        return ans;
    }

    private static void backtrack(int k, int n, int cur, List<List<Integer>> ans, List<Integer> path) {
        if(k==0&&n==0){
            ans.add(new ArrayList<>(path));
            return;
        }
        if (cur>9||cur>n||n>45){
            return;
        }
        path.add(cur);
        backtrack(k-1,n-cur,cur+1,ans,path);
        path.remove(path.size()-1);
        backtrack(k,n,cur+1,ans,path);
    }
}
