package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author suruomo
 * @date 2020/7/25 16:22
 * @description: 剑指offer 59以及239
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class MaxSlidingWindow {
    /**
     * 暴力法：遍历每个滑动窗口，找到每个窗口的最大值
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) {
            return new int[0];
        }
        int [] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            output[i] = max;
        }
        return output;
    }

    /**
     * 单调队列
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length == 0 || k == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0, i = 1 - k; j < nums.length; i++, j++) {
            // 1.右移时若删除元素刚好是队列第一个最大值，则删除 deque 第一个元素
            if(i > 0 && deque.peekFirst() == nums[i - 1]) {
                deque.removeFirst();
            }
            //2.删除deque中比新值nums[j]小的元素，因为这些元素不可能是最大值
            while(!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.removeLast(); // 保持 deque 递减
            }
            //3.将新值nums[j]加到deque尾部
            deque.addLast(nums[j]);
            //4.保存当前窗口最大值
            if(i >= 0) {
                // 记录窗口最大值
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }
}
