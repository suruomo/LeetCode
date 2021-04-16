package interview;

/**
 * @author: suruomo
 * @date: 2021/4/16 10:04
 * @description:  从0,1,2,...,n这n+1个数中选择n个数，找出这n个数中缺失的那个数，要求O(n)尽可能小。
 */
public class FindNumber {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 找缺失数字
     * @param a int整型一维数组 给定的数字串
     * @return int整型f
     */
    public int solve (int[] a) {
        int left=0;
        int right=a.length-1;
        while (left<right){
            int mid=(left+right)/2;
            if (mid==a[mid]){
                left=mid+1;
            }else if(a[mid]>mid){
                right=mid;
            }
        }
        if (left==a[a.length-1]){
            return left+1;
        }
        return left;
    }
}
