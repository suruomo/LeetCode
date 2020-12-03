package offer;

/**
 * @author: suruomo
 * @date: 2020/12/3 13:54
 * @description: 剑指 Offer 57. 和为s的两个数字
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，
 * 使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] ans=new int[2];
        if (nums.length<=1||nums==null){
            return ans;
        }
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int sum=nums[left]+nums[right];
            if (sum==target){
               return new int[]{nums[left],nums[right]};
            }else if(sum<target){
                left++;
            }else {
                right--;
            }
        }
        return ans;
    }
}
