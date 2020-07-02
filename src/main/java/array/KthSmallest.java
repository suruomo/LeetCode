package array;

import java.util.Arrays;

/**
 * 题目378：给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 * @author suruomo
 * @date 2020/7/2 14:44
 */
public class KthSmallest {
    public static void main(String[] args) {
        int[][] matrix={
                {1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k=8;
        System.out.println("第k小元素是："+kthSmallest(matrix,k));
    }

    /**
     * 法1：二维数组合并为一维数组并排序
     * @param matrix
     * @param k
     * @return
     */
    private static int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length, columns = matrix[0].length;
        int[] sorted = new int[rows * columns];
        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sorted[index++] = num;
            }
        }
        Arrays.sort(sorted);
        return sorted[k - 1];
    }
}
