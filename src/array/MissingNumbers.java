import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 苏若墨
 * 问题：给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 思路：排序或者哈希
 */
public class MissingNumbers {
    public static void main(String[] args) {
        int[] nums={3,0,1};
        System.out.println("排序法："+miss(nums));
        System.out.println("哈希法："+hashMiss(nums));
    }

    private static int hashMiss(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }
        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }

    private static int miss(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==1&&nums[0]==0){
            return 1;
        }
        else if(nums.length==1&&nums[0]==1){
            return 0;
        }
        else if(nums[0]!=0&&nums.length!=1){
            return 0;
        }
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]+1!=nums[i+1]){
                return nums[i]+1;
            }
        }
        return nums[nums.length-1]+1;
    }
}
