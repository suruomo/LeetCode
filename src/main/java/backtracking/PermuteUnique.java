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
        backtrack(nums, ans, perm);
        return ans;
    }

    /**
     * 回溯搜索
     * @param nums 目标数组
     * @param ans 结果集
     * @param perm 当前路径
     */
    public void backtrack(int[] nums, List<List<Integer>> ans,  List<Integer> perm) {
        //结束条件
        if (perm.size() == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            //防止重复数字填入，排序后比较
            // 假设我们有 3 个重复数排完序后相邻，那么我们一定保证每次都是拿从左往右第一个未被填过的数字，
            // 即整个数组的状态其实是保证了
            // [未填入，未填入，未填入] 到 [填入，未填入，未填入]，
            // 再到 [填入，填入，未填入]，最后到 [填入，填入，填入] 的过程的，因此可以达到去重的目标。
            if (vis[i] || (i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])) {
                continue;
            }
            //选择
            perm.add(nums[i]);
            vis[i] = true;
            //下一层回溯
            backtrack(nums, ans,  perm);
            //取消选择
            vis[i] = false;
            perm.remove(perm.size()-1);
        }
    }
}
