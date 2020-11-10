package array;

/**
 * @author: suruomo
 * @date: 2020/11/10 9:57
 * @description: 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 */
public class NextPermutation {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        nextPermutation(nums);
    }

    private static void nextPermutation(int[] nums) {
        int i=nums.length-2;
        while (i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        if (i>=0){
            int j=nums.length-1;
            while (j>=0&&nums[i]>=nums[j]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1);
    }

    private static void reverse(int[] nums, int start) {
        int left=start;
        int right=nums.length-1;
        while (left<right){
            swap(nums,left,right);
            right--;
            left++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
