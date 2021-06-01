package interview;

/**
 * @author: suruomo
 * @date: 2021/6/1 11:38
 * @description: 请写出一个高效的在m*n矩阵中判断目标值是否存在的算法，矩阵具有如下特征：
 * 每一行的数字都从左到右排序
 * 每一行的第一个数字都比上一行最后一个数字大
 */
public class SearchMatrix {
    public boolean searchMatrix (int[][] matrix, int target) {
        int rows=matrix.length;
        int columns= matrix[0].length;
        int i=0,j=columns-1;
        while (i>=0&&i<rows&&j>=0&&j<columns){
            if (matrix[i][j]==target){
                return true;
            }
            if (matrix[i][j]>target){
                j--;
            }else {
                i++;
            }
        }
        return false;
    }
}
