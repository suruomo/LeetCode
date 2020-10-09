package array;

/**
 * @author: suruomo
 * @date: 2020/10/9 10:51
 * @description: 48 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。给定一个 n × n 的二维矩阵表示一个图像。
 *
 */
public class RotateArray {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 第一步：转置矩阵，行列对换
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // 第二步：翻转矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }
}
