package sort;

/**
 * @author: suruomo
 * @date: 2021/3/1 14:53
 * @description: 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {3, 2, 7, 4, 8, 9, 0, 1, 6, 5};
        int[] tmp=new int[nums.length];
        mergeSort(nums,0,nums.length-1,tmp);
        System.out.println("排序后数组是：");
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    /**
     * 归并排序
     * @param nums
     * @param low
     * @param high
     * @param tmp
     */
    private static void mergeSort(int[] nums, int low, int high, int[] tmp) {
        if (low<high){
            int mid=(low+high)/2;
            // 右边排序
            mergeSort(nums,low,mid,tmp);
            // 左边排序
            mergeSort(nums,mid+1,high,tmp);
            // 两边最终排序
            sort(nums,low,mid,high,tmp);
        }
    }

    /**
     * 排序过程
     * @param nums
     * @param low
     * @param mid
     * @param high
     * @param tmp
     */
    private static void sort(int[] nums, int low, int mid, int high, int[] tmp) {
        int i=0;
        // 两个待排序序列的左右索引
        int j=low,k=mid+1;
        while (j<=mid&&k<=high){
            if (nums[j]<nums[k]){
                tmp[i++]=nums[j++];
            }else {
                tmp[i++]=nums[k++];
            }
        }
        // 若左边还有剩余
        while (j<=mid){
            tmp[i++]=nums[j++];
        }
        // 若右边还有剩余
        while (k<=high){
            tmp[i++]=nums[k++];
        }
        
        // 排好序部分拷贝至原数组，便于下一次使用
        for (int l = 0; l < i; l++) {
            nums[low+l]= tmp[l];
        }
        
    }
}
