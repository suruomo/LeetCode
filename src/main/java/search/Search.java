package search;

/**
 * @author: suruomo
 * @date: 2020/11/6 11:00
 * @description: 33. 搜索旋转排序数组
 * 给你一个升序排列的整数数组 nums ，和一个整数 target 。
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * （例如，数组[0,1,2,4,5,6,7]可能变为[4,5,6,7,0,1,2] ）。
 * 请你在数组中搜索target ，如果数组中存在这个目标值，则返回它的索引，否则返回-1
 */
public class Search {
    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        int target=0;
        System.out.println(search(nums,target));
    }

    private static int search(int[] nums, int target) {
        int n= nums.length;
        if (n == 0) {
            return -1;
        }
        if (n==1){
            return nums[0] == target ? 0 : -1;
        }
        int l=0,r=n-1;
        while (l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target){
                return mid;
            }
            // 若mid左边是升序数组
            if (nums[0]<nums[mid]){
                if(nums[0]<=target&&target<nums[mid]){
                    r=mid-1;
                }else {
                    l=mid+1;
                }
            }else {
                if (nums[mid]<=target&&target<nums[r]){
                    l=mid+1;
                }else {
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}
