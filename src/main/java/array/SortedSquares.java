package array;

import java.util.Arrays;

/**
 * @author: suruomo
 * @date: 2020/10/16 11:53
 * @description: 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 */
public class SortedSquares {
    public static void main(String[] args) {
        int[] A={-4,-1,0,3,10};
        int[] B=sortedSquares(A);
        for (int i = 0; i < B.length; i++) {
            System.out.println(B[i]);
        }
    }

    private static int[] sortedSquares(int[] A) {
        if(A[0]>=0)
        {
            sort(A);
        }
        else{
            int i=0;
            while (i<A.length&&A[i]<0){
                A[i]=Math.abs(A[i]);
                i++;
            }
            Arrays.sort(A);
            sort(A);
        }
        return A;
    }

    private static void sort(int[] A) {
        int n=A.length;
        for (int i = 0; i < n; i++) {
            A[i]= (int) Math.pow(A[i],2);
        }
    }
}
