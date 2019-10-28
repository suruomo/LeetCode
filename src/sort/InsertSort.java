package sort;

/**
 * 插入排序
 *
 * @author 苏若墨
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {3, 2, 7, 4, 8, 9, 0, 1, 6, 5};
        insertSort(nums);
        System.out.println("插入排序后数组是：");
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    private static void insertSort(int[] nums) {
        int j=0;
        for(int i=1;i<nums.length;i++){
            int temp=nums[i];
            for(j=i;j>0&&nums[j-1]>temp;j--){
                nums[j]=nums[j-1];
            }
            nums[j]=temp;
        }
    }
}
