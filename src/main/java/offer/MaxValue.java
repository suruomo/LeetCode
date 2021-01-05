package offer;

/**
 * @author: suruomo
 * @date: 2021/1/5 10:30
 * @description: 剑指 Offer 47. 礼物的最大价值
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 */
public class MaxValue {
    public int maxValue(int[][] grid) {
        if (grid==null){
            return 0;
        }
        int row= grid.length;
        int col= grid[0].length;
        // 初始化
        // 第一列
        for (int i = 1; i < row; i++) {
            grid[i][0]+=grid[i-1][0];
        }
        // 第一行
        for (int i = 1; i < col; i++) {
            grid[0][i]+= grid[0][i-1];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j]+=Math.max(grid[i-1][j],grid[i][j-1]);
            }
        }
        return grid[row-1][col-1];
    }
}
