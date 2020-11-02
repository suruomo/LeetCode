package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2020/11/2 11:23
 * @description: 349. 两个数组的交集
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1=arrayToSet(nums1);
        HashSet<Integer> set2=arrayToSet(nums2);
        List<Integer> list=new ArrayList<>();
        for (Integer num:set1){
            if (set2.contains(num)){
                list.add(num);
            }
        }
        int[] res=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }

    private HashSet<Integer> arrayToSet(int[] nums) {
        int n= nums.length;
        HashSet<Integer> set=new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        return set;
    }
}
