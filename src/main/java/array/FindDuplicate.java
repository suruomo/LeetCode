package array;

import java.util.Arrays;

/**
 * @author: suruomo
 * @date: 2020/9/18 10:16
 * @description: 287 寻找重复数
 * 给定一个包含n + 1 个整数的数组nums，其数字都在 1 到 n之间（包括 1 和 n）
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 */
public class FindDuplicate {
    public static void main(String[] args) {
        int[] nums={1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }

    /**
     * 暴力解法
     * 排序遍历
     * @param nums
     * @return
     */
    private static int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==nums[i-1]){
                res=nums[i];
            }
        }
        return res;
    }
}
