package array;

/**
 * @author 苏若墨
 * 问题：移除一个数组的某数字，返回当前数组长度
 */
public class RemoveElements {
    public static void main(String[] args) {
        int[] a = {2, 3, 3, 2};
        int val = 3;
        remove(a, val);
    }

    private static void remove(int[] nums, int val) {
        int cur = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[cur++] = nums[i];
                count++;
            }
        }
        System.out.println("数组长度是：" + count);
    }
}
