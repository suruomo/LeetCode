package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 苏若墨
 * 问题：给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * <p>
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * <p>
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 思路：哈希法
 */
public class MissNumbers {
    public static void main(String[] args) {
        int[] nums = {3, 1, 0};
        miss(nums);
    }

    private static List<Integer> miss(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                list.add(number);
            }
        }
        return list;
    }
}
