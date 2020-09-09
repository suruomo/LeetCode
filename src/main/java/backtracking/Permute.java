package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: suruomo
 * @Date: 2020/9/9 15:38
 * @Description:
 */
public class Permute {

    /**
     * 结果集
     */
    private static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        //路径
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    private static void backtrack(int[] nums, LinkedList<Integer> track) {
        // 路径：记录在 track 中
        // 选择列表：nums 中不存在于 track 的那些元素
        // 结束条件：nums 中的元素全都在 track 中出现
        if (track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {
                continue;
            }
            //做选择
            track.add(nums[i]);
            //进入下一层决策树
            backtrack(nums, track);
            //撤销选择
            track.removeLast();
        }
    }
}
