package array;

/**
 * @author: suruomo
 * @date: 2021/1/8 11:53
 * @description: 162. 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 *
 * 给定一个输入数组nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 *
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 *
 * 你可以假设nums[-1] = nums[n] = -∞。
 *
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums.length - 1;
    }
}
