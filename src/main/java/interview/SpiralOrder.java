package interview;

import java.util.ArrayList;

/**
 * @author: suruomo
 * @date: 2021/3/30 14:20
 * @description: 螺旋矩阵
 * 给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
 */
public class SpiralOrder {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list=new ArrayList<>();
        int rows= matrix.length;
        int columns= matrix[0].length;
        // 定义四个边界
        int top=0;
        int left=0;
        int right=columns-1;
        int bottom=rows-1;
        while (left<=right&&top<=bottom){
            // 1.从左向右
            for (int col = left; col <=right; col++) {
                list.add(matrix[top][col]);
            }
            // 从上向下
            for (int r = top+1;  r <=bottom;  r++) {
                list.add(matrix[r][right]);
            }
            if (left<right&&top<bottom){
                // 3.从右向左
                for (int r = right-1; r >=left; r--) {
                    list.add(matrix[bottom][r]);
                }
                // 4.从下向上
                for (int i = bottom-1; i >top; i--) {
                    list.add(matrix[i][left]);
                }
            }
            // 修改边界
            left++;
            right--;
            top++;
            bottom--;
        }
        return list;
    }
}
