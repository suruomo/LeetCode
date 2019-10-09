package array;

/**
 * @author 苏若墨
 * 问题：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 思路：双指针
 */
public class MoveZero {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZero(nums);
    }

    private static void moveZero(int[] nums) {
        int q = 0, cur = 0;
        while (cur < nums.length) {
            if (nums[cur] != 0) {
                nums[q++] = nums[cur++];
            } else {
                cur++;
            }
        }
        while (q < nums.length) {
            nums[q++] = 0;
        }
    }

}
