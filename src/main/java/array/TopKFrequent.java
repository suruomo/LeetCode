package array;

import java.util.*;

/**
 * @Author: suruomo
 * @Date: 2020/9/7 16:13
 * @Description: 347 前K个高频元素
 */
public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums={1,1,1,2,2,3};
        int k=2;
        System.out.println(topKFrequent(nums,k));
    }

    private static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        //如果堆的元素个数小于 k，就可以直接插入堆中。
        //如果堆的元素个数等于 k，则检查堆顶与当前出现次数的大小。
        // 如果堆顶更大，说明至少有 k 个数字的出现次数比当前值大，故舍弃当前值；
        // 否则，就弹出堆顶，并将当前值插入堆中。
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }
}
