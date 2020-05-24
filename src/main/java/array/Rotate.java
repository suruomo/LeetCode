package array;

/**
 * 问题189：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * @author 苏若墨
 */
public class Rotate {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        int k=3;
        rotate(nums,k);
    }

    /**
     * 我们可以用一个额外的数组来将每个元素放到正确的位置上，
     * 也就是原本数组里下标为 ii 的我们把它放到 (i+k)\%数组长度(i+k)%数组长度 的位置。
     *然后把新的数组拷贝到原数组中。
     * @param nums
     * @param k
     */
    private static void rotate(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }
}
