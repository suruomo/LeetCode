package interview;

import java.util.Arrays;

/**
 * @Author: suruomo
 * @Date: 2021/7/13 11:03
 * @Description: 数组中的最长连续子序列
 * 给定无序数组arr，返回其中最长的连续序列的长度(要求值连续，
 * 位置可以不连续,例如 3,4,5,6为连续的自然数）
 */
public class MIS {
    public int MLS (int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        int maxcount=1;
        int count=1;
        for (int i = 0; i < n-1; i++) {
            if(arr[i]==arr[i+1]){
                continue;
            }
            if (arr[i] + 1 == arr[i + 1]){
                count++;
            }else{
                count=1;
            }
            maxcount=Math.max(count,maxcount);
        }
        return maxcount;
    }
}
