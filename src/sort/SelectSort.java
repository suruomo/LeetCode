package sort;

/**
 * 选择排序
 * @author 苏若墨
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums={3,2,7,4,8,9,0,1,6,5};
        selectSort(nums);
        System.out.println("排序后数组是：");
        for(int num:nums) {
            System.out.print(num+",");
        }
    }

    private static void selectSort(int[] nums) {
        //min记住一趟排序中最小值的下标
        int min=0;
        for(int i=0;i<nums.length;i++){
            min=i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[min]){
                    min=j;
                }
            }
            if(min!=i){
                int temp=nums[i];
                nums[i]=nums[min];
                nums[min]=temp;
            }
        }
    }
}
