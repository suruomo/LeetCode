package interview;

/**
 * @author: suruomo
 * @date: 2021/3/26 13:32
 * @description: 给出两个有序的整数数组 和 ，请将数组 合并到数组 中，变成一个有序的数组
 * 注意：
 * 可以假设 数组有足够的空间存放 数组的元素， 和 中初始的元素数目分别为 和
 */
public class Merge {
    public void merge(int A[], int m, int B[], int n) {
        int[] C = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (A[i] <= B[j]) {
                C[k++] = A[i++];
            } else {
                C[k++] = B[j++];
            }
        }
        while (i < m) {
            C[k++] = A[i++];
        }
        while (j < n) {
            C[k++] = B[j++];
        }

        for (int t = 0; t < C.length; t++) {
            A[t] = C[t];
        }
    }
}
