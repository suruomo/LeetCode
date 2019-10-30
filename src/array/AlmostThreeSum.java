package array;

import java.util.Arrays;

/**
 * 问题：
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * @author 苏若墨
 */
public class AlmostThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target=4;
        System.out.println("最接近目标值"+target+"的结果是："+almostThreeSum(nums,target));
    }

    private static int almostThreeSum(int[] nums,int target) {
        if(nums==null||nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int result=nums[0]+nums[1]+nums[2];
        for(int i=0;i<nums.length-2;i++){
            //i去重
            if(i>0&&nums[i]==nums[i+1]){
                continue;
            }
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
                int sum=nums[i]+nums[l]+nums[r];
                //绝对值比较
                if(Math.abs(sum-target)<Math.abs(result-target)){
                    result=sum;
                }
                //l去重
                if(sum<target){
                    while(l<r&&nums[l]==nums[l+1]){
                        l++;
                    }
                    l++;
                }
                //r去重
                else{
                    while(l<r&&nums[r]==nums[r-1]){
                        r--;
                    }
                    r--;
                }
            }
        }
        return result;
    }
}
