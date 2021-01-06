package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2021/1/5 19:03
 * @description: 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        backtrack(res,path,n,k,0,1);
        return res;
    }

    /**
     * 回溯
     * @param res 结果集
     * @param path 当前路径
     * @param n
     * @param k
     * @param count 当前选择数个数（可不用，用path.size代替）
     * @param idx 当前遍历索引
     */
    private void backtrack(List<List<Integer>> res, List<Integer> path, int n,int k,int count, int idx) {
        if (count==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = idx; i < n; i++) {
            path.add(i);
            count++;
            backtrack(res, path, n, k, count, i+1);
            path.remove(path.size()-1);
            count--;
        }
    }
}
