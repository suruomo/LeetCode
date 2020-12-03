package offer;

/**
 * @author: suruomo
 * @date: 2020/12/3 13:52
 * @description: 剑指 Offer 29. 顺时针打印矩阵
 */
public class SpiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        // 四边界
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        // 遍历
        while (left <= right && top <= bottom) {
            // 从左向右
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            //从上向下
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                // 从右向左
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                // 从下向上
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            // 修改边界
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
