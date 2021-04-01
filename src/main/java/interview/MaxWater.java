package interview;

/**
 * @author: suruomo
 * @date: 2021/4/1 10:09
 * @description:
 * 给定一个整形数组arr，已知其中所有的值都是非负的，将这个数组看作一个容器，请返回容器能装多少水。
 */
public class MaxWater {
    /**
     * max water
     * @param arr int整型一维数组 the array
     * @return long长整型
     */
    public long maxWater (int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }
        long maxwater = 0;
        long[] leftmax = new long[arr.length];
        long[] rightmax = new long[arr.length];
        leftmax[0] = arr[0];
        rightmax[arr.length - 1] = arr[arr.length - 1];
        // leftmax[i]表示第i个元素左边最大值
        for (int i = 1; i < arr.length; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], arr[i]);
        }
        // leftmax[i]表示第i个元素右边最大值
        for (int i = arr.length - 2; i >= 0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], arr[i]);
        }
        // 遍历累加存水量
        for (int i = 1; i < arr.length - 1; i++) {
            maxwater = maxwater + Math.max(Math.min(leftmax[i - 1], rightmax[i + 1]) - arr[i], 0);
        }
        return maxwater;
    }

}
