package array;

import java.util.HashSet;

/**
 * 问题：136 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * @author 苏若墨
 */
public class SingleNumber {
    public static void main(String[] args) {
        int[] nums={1,2,3,2,4,3,4};
        System.out.println(singleNumber(nums));
    }

    /**
     * HashSet
     * @param nums
     * @return
     */
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

    /**
     * 位运算
     * 任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
     * 任何数和其自身做异或运算，结果是 0，即a⊕a=0。
     * @param nums
     * @return
     */
    public static int singleNumber1(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }

}
