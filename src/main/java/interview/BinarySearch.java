package interview;

/**
 * @author: suruomo
 * @date: 2021/4/26 10:59
 * @description: 请实现有重复数字的升序数组的二分查找
 */
public class BinarySearch {
    /**
     *
     * 如果目标值存在返回下标，否则返回 -1
     *
     * 重复数字返回第一次出现下标
     * @param nums int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search (int[] nums, int target) {
        int left=0;
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while(low <= high){
            mid = low+ (high- low) / 2;
            if(nums[mid] == target){
                while(mid != 0 &&(nums[mid-1] == nums[mid])){
                    mid--;
                }
                return mid;
            }
            else if(nums[mid] > target){
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
