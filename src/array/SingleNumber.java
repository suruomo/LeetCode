package array;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 问题：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @author 苏若墨
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums={1,2,3,2,4,3,4};
        System.out.println(singleNumber(nums));
    }

    private static int singleNumber(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            if(set.contains(num)){
                set.remove(num);
            }
            else{
                set.add(num);
            }
        }
       return set.iterator().next();
    }
}
