import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;

import java.util.HashMap;

/**
 * @author 苏若墨
 * 问题：给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 思路：哈希法，存储每个元素出现的次数
 *
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums={1};
        findMajority(nums);
    }

    private static void findMajority(int[] nums) {
        HashMap<Integer, Integer> counts=new HashMap<>();
        for(int num:nums){
            if(!counts.containsKey(num)){
                if(nums.length==1){
                    System.out.println("众数"+num+"出现次数："+1);
                    return;
                }
                counts.put(num,1);
            }
            else{
                counts.put(num,counts.get(num)+1);
                if(counts.get(num)>(nums.length/2)){
                    System.out.println("众数"+num+"出现次数："+counts.get(num));
                    return;
                }
            }
        }

    }
}
