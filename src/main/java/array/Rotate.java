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
     * 1.我们可以用一个额外的数组来将每个元素放到正确的位置上，
     * 也就是原本数组里下标为 i 的我们把它放到 (i+k)\%数组长度的位置。
     * 然后把新的数组拷贝到原数组中。
     * 但是空间复杂度是O(n)
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

    /**
     * 2. 数组翻转
     * 如：1，2，3，4，5，6，7
     * @param nums
     * @param k
     */
    private static void rotate1(int[] nums, int k) {
        k%=nums.length;
        // 翻转全部数组：7，6，5，4，3，2，1
        reverse(nums,0,nums.length-1);
        // 翻转前k个：5，6，7，4，3，2，1，
        reverse(nums,0,k-1);
        // 翻转剩余数组：5，6，7，1，2，3，4
        reverse(nums,k,nums.length-1);
    }

    /**
     * 数组翻转
     * @param nums
     * @param start 起始下标
     * @param end 结束下标
     */
    private static void reverse(int[] nums, int start, int end) {
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
