package bfs_dfs;

/**
 * @author: suruomo
 * @date: 2021/6/20 15:34
 * @description: 矩阵最长递增路径
 * 给定一个矩阵，矩阵内所有数均为非负整数。
 * 求一条路径，该路径上所有数是递增的。
 * 这个路径必须满足以下条件：
 * 1、对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外。
 * 2、你不能走重复的单元格。即每个格子最多只能走一次。
 */
public class LongestIncrementalPath {
    public int solve (int[][] matrix) {
        int max = 0;
        // 每个结点都有可能是开始，因此要遍历每一个结点
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                max = Math.max(max, dfs(matrix, i, j, -1));
            }
        }
        return max;
    }

    /**
     * 深度优先遍历
     * @param mat
     * @param i
     * @param j
     * @param pre 前一个位置的值
     * @return
     */
    private int dfs (int[][] mat, int i, int j, int pre){
        // 不满足递增条件
        if(mat[i][j] <= pre){
            return 0;
        }
        int max = 0;
        // 四个方向分别遍历
        if(i > 0){
            max = Math.max(max, dfs(mat, i - 1, j, mat[i][j]));
        }
        if(j > 0){
            max = Math.max(max, dfs(mat, i, j - 1, mat[i][j]));
        }
        if(i < mat.length - 1){
            max = Math.max(max, dfs(mat, i + 1, j, mat[i][j]));
        }
        if(j < mat[i].length - 1){
            max = Math.max(max, dfs(mat, i, j + 1, mat[i][j]));
        }
        return max + 1;
    }

}
