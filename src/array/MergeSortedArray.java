package array;

/**
 * @author 苏若墨
 * 问题：
 * 合并两个有序数组
 * 思路：将指针p1 置为 nums1的开头， p2为 nums2的开头，在每一步将最小值放入输出数组中。
 */
public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {4, 5, 6};
        merge(nums1, 3, nums2, 3);
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] numsNew = new int[m + n];
        int p1 = 0, p2 = 0, p = 0;
        while ((p1 < m) && (p2 < n)) {
            numsNew[p++] = (nums1[p1] < nums2[p2]) ? nums1[p1++] : nums2[p2++];
        }
        while (p1 < m) {
            numsNew[p++] = nums1[p1++];
        }
        while (p2 < n) {
            numsNew[p++] = nums2[p2++];
        }
        System.arraycopy(numsNew, 0, nums1, 0, n + m);
    }
}
