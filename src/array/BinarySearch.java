package array;

/**
 * @author 苏若墨
 * 问题：二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3};
        boolean flag;
        flag = search(nums.length, nums, 3);
    }

    private static boolean search(int length, int[] nums, int i) {
        int left = 0;
        int right = length - 1;
        int mid;
        while (left <= right) {
            mid = (right + left) / 2;
            if (nums[mid] == i) {
                return true;
            } else if (nums[mid] > i) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
