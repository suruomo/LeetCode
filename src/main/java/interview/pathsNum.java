package interview;

/**
 * @author: suruomo
 * @date: 2021/4/12 10:04
 * @description: 一个机器人在m×n大小的地图的左上角（起点）。
 * 机器人每次向下或向右移动。机器人要到达地图的右下角（终点）。
 * 可以有多少种不同的路径从起点走到终点？
 */
public class pathsNum {
    /**
     *
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public int uniquePaths (int m, int n) {
        if (m==1&&n==1){
            return 1;
        }
        int[][] dp= new int[m][n];
        // 初始化
        for (int i = 1; i <m; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <n; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i <m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
