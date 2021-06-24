package offer;

/**
 * @Author: suruomo
 * @Date: 2021/6/24 9:53
 * @Description: 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，
 * 其中B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 */
public class ConstructArr {
    public int[] constructArr(int[] a) {
        int length = a.length;
        int[] answer = new int[length];
        if (length==0){
            return answer;
        }
        // L 和 R 分别表示左右两侧的乘积列表
        int[] L = new int[length];
        int[] R = new int[length];

        // L[i] 为索引 i 左侧所有元素的乘积
        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
        // 对于其他元素：L[i] = L[i-1] * nums[i-1]
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = a[i - 1] * L[i - 1];
        }

        // R[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
        // 其他元素：R[i] = R[i+1] * nums[i+1]
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = a[i + 1] * R[i + 1];
        }

        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;
    }
}
