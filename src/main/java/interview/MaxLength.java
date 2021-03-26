package interview;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: suruomo
 * @date: 2021/3/26 13:12
 * @description:
 * 给定一个数组arr，返回arr的最长无的重复子串的长度(无重复指的是所有数字都不相同)。
 */
public class MaxLength {
    /**
     *
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        // write code here
        int maxLength=0;
        int start=0,end=0;
       HashMap<Integer,Integer> map=new HashMap<>();
        for (; end<arr.length; end++) {
            if (map.containsKey(arr[end])){
                //注意：这里一定要取最大的start，不然就错误了
                //为什么？ 因为重复数字的索引很可能比start小
                start=Math.max(start,map.get(arr[end])+1);
            }
            maxLength=Math.max(maxLength,end-start+1);
            map.put(arr[end],end);
        }
        return maxLength;
    }
}
