package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: suruomo
 * @Date: 2020/9/9 15:53
 * @Description:  40 组合总和2
 * 给定一个无重复元素的数组candidates和一个目标数target，
 * 找出candidates中所有可以使数字和为target的组合。
 * 注意：
 * candidates中的数字只能被选取一次。
 */
public class CombinationSum2 {

    public static void main(String[] args) {
        int[] candidates={10,1,2,7,6,1,5};
        int target=8;
        System.out.println(combinationSum2(candidates,target));
    }

    /**
     * 搜索+回溯
     * @param candidates 无重复元素的数组
     * @param target 目标数
     * @return
     */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //结果集
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(target<=0||candidates.length==0){
            return ans;
        }
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
            //选择下一位，避免重复,可重复为i
            dfs(candidates, target-candidates[i], ans, combine, i + 1);
            //撤销选择
            combine.remove(combine.size() - 1);
        }
    }
}
