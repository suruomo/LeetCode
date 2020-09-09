package backtracking;

import java.util.ArrayList;
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
    public static void main(String[] args) {
        int[] candidates={2,3,6,7};
        int target=7;
        System.out.println(combinationSum(candidates,target));
    }

    /**
     * 搜索+回溯
     * @param candidates 无重复元素的数组
     * @param target 目标数
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //结果集
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
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
        //结束条件1：当前数组已经遍历完
        if (idx == candidates.length) {
            return;
        }
        //结束条件2：没有可组合数字target，即target<=0
        if (target == 0) {
            ans.add(new ArrayList<Integer>(combine));
            return;
        }
        // 继续情况1：直接跳过找下一位数字
        dfs(candidates, target, ans, combine, idx + 1);
        // 继续情况2：选择当前数
        if (target - candidates[idx] >= 0) {
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }
}
