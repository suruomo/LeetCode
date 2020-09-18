package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2020/9/18 9:40
 * @description: 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 */
public class PermuteUnique {
    /**
     * 标记已经填过的数
     */
    boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    /**
     * 回溯搜索
     * @param nums 目标数组
     * @param ans 结果集
     * @param idx 当前遍历位置
     * @param perm 当前路径
     */
    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        //结束条件
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            //防止重复数字填入，排序后比较
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            //选择
            perm.add(nums[i]);
            vis[i] = true;
            //下一层回溯
            backtrack(nums, ans, idx + 1, perm);
            //取消选择
            vis[i] = false;
            perm.remove(idx);
        }
    }
}
