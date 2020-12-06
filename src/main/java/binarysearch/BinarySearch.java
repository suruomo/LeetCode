package binarysearch;

/**
 * @author: suruomo
 * @date: 2020/12/4 14:40
 * @description: 二分查找几种情况
 * leetcode 704. 二分查找
 * leetcode 34. 在排序数组中查找元素的第一个和最后一个位置
 * leetcode 315.计算右侧小于当前元素的个数
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] nums={1,2,3,3,4,5,5};
        int target=5;
        System.out.println(searchRightIndex(nums,target));
    }
    /**
     * 1.最基本：不重复递增数组查找目标值
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearch(int[] nums,int target){
        int left=0,right=nums.length-1;
        // 当left,right被更新后，会出现left==right的情况
        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }
        }
        return -1;
    }

    /**
     * 2.查找重复数组中目标值左边界
     * @param nums
     * @param target
     * @return
     */
    public static int searchLeftIndex(int[] nums,int target){
        int left=0,right=nums.length-1;
        // 当找到目标的时候，保持右侧right指向target,然后left继续逼近right
        // 最终将left和right将在最左侧的target位置相遇
        while (left<right){
            int mid=(left+right)/2;
            if (nums[mid]>=target){
                right=mid;
            }else{
               left=mid+1;
            }
        }
        if (nums[left]==target){
            return left;
        }
        return -1;
    }

    /**
     * 3.查找重复数组中目标值右边界
     * @param nums
     * @param target
     * @return
     */
    public static int searchRightIndex(int[] nums,int target){
        int left=0,right=nums.length-1;
        // 当找到目标的时候，保持右侧right指向target,然后left继续逼近right
        // 最终将left和right将在最左侧的target位置相遇
        while (left<right){
            // 注意，这里取偏右的中值，【防止死循环】
            int mid=(left+right+1)/2;
            if (nums[mid]<=target){
                left=mid;
            }else{
                right=mid-1;
            }
        }
        if (nums[left]==target){
            return left;
        }
        return -1;
    }
}
