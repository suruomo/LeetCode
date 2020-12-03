package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2020/12/3 13:36
 * @description: 54. 螺旋矩阵
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列）
 * 请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return list;
        }
        int rows= matrix.length;
        int columns= matrix[0].length;
        // 定义四边界
        int left=0;
        int right=columns-1;
        int top=0;
        int bottom=rows-1;
        // 按层遍历
        while (left<=right&&top<=bottom){
            // 从左向右
            for (int column = left; column <=right; column++) {
                list.add(matrix[top][column]);
            }
            // 从上向下
            for (int row = top+1; row <=bottom; row++) {
                list.add(matrix[row][right]);
            }
            if (left < right && top < bottom) {
                // 从右向左
                for (int column = right - 1; column > left; column--) {
                    list.add(matrix[bottom][column]);
                }
                for (int row = bottom ; row > top; row--) {
                    list.add(matrix[row][left]);
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
