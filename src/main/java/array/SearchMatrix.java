package array;

/**
 * @author: suruomo
 * @date: 2020/11/10 10:35
 * @description: 240. 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。
 * 该矩阵具有以下特性：
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 */
public class SearchMatrix {
    /**
     * 暴力法
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j< matrix[0].length;j++){
                if (matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 利用有序特性，从左下角向上搜索
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix1(int[][]matrix,int target){
        // start our "pointer" in the bottom-left
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else { // found it
                return true;
            }
        }
        return false;
    }

}
