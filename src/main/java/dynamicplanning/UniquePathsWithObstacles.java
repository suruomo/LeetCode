package dynamicplanning;


/**
 * 问题63:考虑不同路径网格中包含障碍的情况
 * @author 苏若墨
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        int m=3,n=3;
        int[][] obstacleGrid=new int[m][n];
        obstacleGrid[2][1]=1;
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
}

    private static int  uniquePathsWithObstacles(int[][] obstacleGrid) {
        int R = obstacleGrid.length;
        int C = obstacleGrid[0].length;

        // 若出发点有障碍返回0
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        //否则出发点无障碍
        obstacleGrid[0][0] = 1;

        // 填充第一列
        for (int i = 1; i < R; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i - 1][0] == 1) ? 1 : 0;
        }

        // 填充第一行
        for (int i = 1; i < C; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i - 1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
//                    否则该点有障碍，设为0
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[R-1][C-1];
    }
}
