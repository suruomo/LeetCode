package sort;

/**
 * 希尔排序
 * @author 苏若墨
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] nums = {3, 2, 7, 4, 8, 9, 0, 1, 6, 5};
        shellSort(nums);
        System.out.println("希尔排序后数组是：");
        for (int num : nums) {
            System.out.print(num + ",");
        }
    }

    private static void shellSort(int[] nums) {
        int j=0;
        for(int gap=nums.length/2;gap>0;gap=gap/2){
            for (int i=gap;i<nums.length;i++){
                int temp=nums[i];
                for(j=i;j>=gap&&nums[j-gap]>temp;j=j-gap){
                    nums[j]=nums[j-gap];
                }
                nums[j]=temp;
            }
        }
    }
}
