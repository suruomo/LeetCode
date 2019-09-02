/**@author 苏若墨
 * 问题：Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * 思路：
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int[]a={0,1,2,3,6,8};
        int val=2;
        int r=findPosition(a,val);
        System.out.println("位置："+r);
    }

    private static int findPosition(int[] nums, int val) {
        for(int i = 0; i < nums.length;i++){
            if(nums[i] >= val){
                return i;
            }
        }
        return nums.length;
    }
}
