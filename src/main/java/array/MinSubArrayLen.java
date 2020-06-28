package array;

import java.util.Arrays;

/**
 * 问题209长度最小的数组：给定一个含有 n 个正整数的数组和一个正整数 s ，
 * 找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * @author 苏若墨
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums={2,3,1,2,4,3};
        int s=7;
        System.out.println("暴力解法是:"+minSubArrayLen(s,nums));
        System.out.println("队列相加或者双指针解法是:"+minSubArrayLen1(s,nums));
        System.out.println("二分法解法是:"+minSubArrayLen2(s,nums));
    }

    /**
     * 二分法
     * 使用临时数组sums，其中sums[i]表示的是原数组nums前i个元素的和，也就是sums数组中的元素是递增的
     * 只需要找到一个小标k使得sums[k]-sums[j]>=s，那么k-j就是满足的连续子数组，但不一定是最小的，所以我们要继续找，直到找到最小的为止。
     *换种思路，求sums[k]-sums[j]>=s相当于我们可以求sums[j]+s<=sums[k]，那这样就好办了
     * 因为数组sums中的元素是递增的，也就是排序的，我们只需要求出sum[j]+s的值，然后使用二分法查找即可找到这个k。
     * @param s
     * @param nums
     * @return
     */
    private static int minSubArrayLen2(int s, int[] nums) {
        int length = nums.length;
        int min = Integer.MAX_VALUE;
        int[] sums = new int[length + 1];
        //初始化sums数组
        for (int i = 1; i <= length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        for (int i = 0; i <= length; i++) {
            //待查找目标下标值
            int target = s + sums[i];
            int index = Arrays.binarySearch(sums, target);
            //找不到返回负数，与源码有关，取反为该数本应该在数组中的位置
            if (index < 0) {
                index = ~index;
            }
            if (index <= length) {
                min = Math.min(min, index - i);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * 队列相加或双指针解法：把数组中的元素不停的入队，直到总和大于等于s为止，接着记录下队列中元素的个数，
     * 然后再不停的出队，直到队列中元素的和小于s为止
     * （如果不小于s，也要记录下队列中元素的个数，这个个数其实就是不小于s的连续子数组长度，我们要记录最小的即可）。
     * 接着再把数组中的元素添加到队列中……重复上面的操作，直到数组中的元素全部使用完为止。
     * @param s
     * @param nums
     * @return
     */
    private static int minSubArrayLen1(int s, int[] nums) {
        //双指针
        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
        //遍历每一个元素
        while (right < nums.length) {
            //相当于进队
            sum += nums[right++];
            while (sum >= s) {
                min = Math.min(min, right - left);
                //相当于出队
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     *暴力法：使用两个for循环，一个for循环固定一个数字m作为子数组的开始下标，另一个for循环从m的素开始累加求和，
     * 当和大于等于s的时候终止内层循环，顺便记录下最小长度
     * @param s
     * @param nums
     * @return
     */
    private static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
