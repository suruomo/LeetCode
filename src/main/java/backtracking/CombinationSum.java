package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: suruomo
 * @Date: 2020/9/9 15:53
 * @Description:  39 组合总和
 * 给定一个无重复元素的数组candidates和一个目标数target，
 * 找出candidates中所有可以使数字和为target的组合。
 * 注意：
 * candidates中的数字可以无限制重复被选取。
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //结果集
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(target<=0||candidates.length==0){
            return ans;
        }
        // 先排序！！！！！！
        Arrays.sort(candidates);
        //已经选择路径
        List<Integer> combine = new ArrayList<Integer>();
        //回溯
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    /**
     *
     * @param candidates 无重复元素的数组
     * @param target 还剩target要组合
     * @param ans 结果集合
     * @param combine 已经选择路径
     * @param idx 当前在数组candidates位置
     */
    public static void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        //结束条件：当前数组已经遍历完
        if (target==0) {
            ans.add(new ArrayList<>(combine));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            // 大剪枝
            if (target - candidates[i] < 0) {
                break;
            }
            // 小剪枝
            if (i > idx && candidates[i] == candidates[i - 1]) {
                continue;
            }
            //选择
            combine.add(candidates[i]);
            // 限制下一次选择的起点，是基于本次的选择，这样下一次就不会选到本次选择的同层左边的数
            // 选择下一位可重复为i
            dfs(candidates, target-candidates[i], ans, combine, i);
            //撤销选择
            combine.remove(combine.size() - 1);
        }
    }
}
