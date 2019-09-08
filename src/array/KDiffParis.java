package array;
import java.util.*;

/**
 * @author 苏若墨
 * 问题：给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。
 * 这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
 * 思路：哈希法
 */
public class KDiffParis {
    public static void main(String[] args) {
        int[]nums={1,3,1,5,4};
        int k=0;
        diffParis(nums,k);
    }

    private static void diffParis(int[] nums, int k) {
        if(k<0){
            System.out.print("0");
        }
        //存储已经遍历过的数字
        Set<Integer> haved=new HashSet<>();
        //存储符合条件一堆数字中的较小数字
        Set<Integer> c=new HashSet<>();
        for(int num:nums){
            if(haved.contains(num+k)){
                c.add(num);
            }
            else if(haved.contains(num-k)){
                c.add(num-k);
            }
            else if(haved.contains(num-k)&&haved.contains(num+k)){
                c.add(num-k);
                c.add(num);
            }
            haved.add(num);
        }
        System.out.print(c.size());
    }
}
