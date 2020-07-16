package offer;

/**
 * @author suruomo
 * @date 2020/7/16 20:00
 * @description: . 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class Exchange {
    public int[] exchange(int[] nums) {
        int n=nums.length;
        //index记录第一个偶数位置
        int index=0;
       for(int i=0;i<n;i++){
           if(nums[i]%2==0){
               continue;
           }else{
               //若当前是奇数，与第一位偶数位置互换，第一位偶数位置后移一位
               int temp=nums[i];
               nums[i]=nums[index];
               nums[index]=temp;
               index++;
           }
       }
       return nums;
    }
}
