package interview;


/**
 * @Author: suruomo
 * @Date: 2021/7/15 13:50
 * @Description: 给定一个整数数组nums，按升序排序，数组中的元素各不相同。
 * nums数组在传递给search函数之前，会在预先未知的某个下标 t（0 <= t <= nums.length-1）上进行旋转，
 * 让数组变为[nums[t], nums[t+1], ..., nums[nums.length-1], nums[0], nums[1], ..., nums[t-1]]。
 * 比如，数组[0,2,4,6,8,10]在下标3处旋转之后变为[6,8,10,0,2,4]
 * 现在给定一个旋转后的数组nums和一个整数target，
 * 请你查找这个数组是不是存在这个target，如果存在，那么返回它的下标，如果不存在，返回-1
 */
public class SpiralArray {
    public int search (int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]>target){
                if (nums[mid]>nums[right]){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }else {
                if (nums[mid]<nums[right]){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}
