package dynamicplanning;

/**
 * 问题：
 *给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 * 会多次调用 sumRange 方法。
 * @author 苏若墨
 */
public class RangeSumQuery {
    private static int[] sum;
    public static void main(String[] args) {
        int[] nums={1,4,2,5,6,9,0,3};
        NumArray(nums);
        System.out.println(sumRange(1,6));
    }

    private static int sumRange(int i, int j) {
        return sum[j]-sum[i-1];
    }

    private static void NumArray(int[] nums) {
        sum=new int[nums.length+1];
        for(int i=1;i<nums.length;i++){
            sum[i]+=sum[i-1]+nums[i];
        }
    }
}
