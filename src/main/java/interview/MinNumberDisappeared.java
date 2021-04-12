package interview;

/**
 * @author: suruomo
 * @date: 2021/4/12 13:18
 * @description: 给定一个无序数组arr，找到数组中未出现的最小正整数
 */
public class MinNumberDisappeared {
    /**
     * return the min number
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int minNumberDisappeared (int[] arr) {
        // 是否是第一个正数
        boolean f=true;
        // 记录1开始
        int first=0;
        for (int i = 0; i <arr.length ; i++) {
            // 1.负数跳过
            if (arr[i]<=0){
                continue;
            }
            // 2.如果是第一个正数但是大于1，则返回1
            if (arr[i]>1&&f){
                return 1;
            }
            // 3.如果是第一个正数且为1，则开始记录
            if (arr[i]==1&&f){
                first=1;
                f=false;
            }
            if (arr[i]==first){
                first++;
                continue;
            }
            return first;
        }
        return arr[arr.length-1]+1;
    }
}
