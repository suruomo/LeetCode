package array;

import java.util.Arrays;

/**
* @Author: suruomo
* @Date: 2020/9/15 9:56
* @Description:  581 给定一个整数数组，你需要寻找一个连续的子数组，
 * 如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
*/public class FindUnsortedSubarray {
    public static void main(String[] args) {
        int[] nums={2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray1(nums));
        System.out.println(findUnsortedSubarray2(nums));
    }

    /**
     * 将数组 nums进行排序，记为 nums_sorted。
     * 然后我们比较 nums 和 nums_sorted的元素来决定最左边和最右边不匹配的元素。
     * 它们之间的子数组就是要求的最短无序子数组。
     * @param nums
     * @return
     */
    private static  int findUnsortedSubarray2(int[] nums) {
        int[] snums = nums.clone();
        Arrays.sort(snums);
        int start = snums.length, end = 0;
        for (int i = 0; i < snums.length; i++) {
            if (snums[i] != nums[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end - start >= 0 ? end - start + 1 : 0);
    }

    private static int findUnsortedSubarray1(int[] nums) {
        int l=nums.length;
        int r=0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                //如果存在 nums[j] 比nums[i] 小，
                // 这意味着 nums[i] 和 nums[j] 都不在排序后数组中的正确位置。
                // 因此我们需要交换这两个元素使它们到正确的位置上。
                //找到不是正确位置的最左边界和最右边界
                if(nums[j]<nums[i]){
                    r=Math.max(r,j);
                    l=Math.min(l,i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }
}
