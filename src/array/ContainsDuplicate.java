package array;

import java.util.HashMap;

/**
 * @author 苏若墨
<<<<<<< HEAD
 * 问题：若一个数组包含重复数字返回true,否则false;
 * 思路：哈希表
=======
>>>>>>> master
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int [] nums={2,3,1};
        System.out.println("结果是"+contains(nums));
    }

    private static boolean contains(int[] nums) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for(int num:nums){
            if(!hashMap.containsKey(num)){
                hashMap.put(num,1);
            }
            else{
               return true;
            }
        }
        return false;
    }
}
