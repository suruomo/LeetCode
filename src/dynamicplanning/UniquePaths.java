package dynamicplanning;

import java.util.Arrays;

/**
 * 问题62：一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 * @author 苏若墨
 */
public class UniquePaths {
    public static void main(String[] args) {
        int m=7;
        int n=3;
        uniquePaths(m,n);
        optUniquePaths1(m,n);
        optUniquePaths2(m,n);
    }
    /**
     * 普通动态规划实现，复杂度m*n
     * @param m
     * @param n
     */
    private static void uniquePaths(int m, int n) {
//        令 dp[i][j] 是到达 i, j 最多路径
        int[][] dp=new int[m][n];
//        第一行，第一列在边界处所以初始化到达路径为1
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int j=0;j<m;j++){
            dp[j][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        System.out.println("普通路径数是："+dp[m-1][n-1]);
    }

    /**
     * 优化1：节省空间，只保留当前行数据以及上一行数据即可，空间复杂度为2n
     * @param m
     * @param n
     */
    public static void optUniquePaths1(int m,int n){
         int[] pre=new int[n];
         int[] cur=new int[n];
        Arrays.fill(pre,1);
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] = cur[j-1] + pre[j];
            }
            pre = cur.clone();
        }
        System.out.println("优化1路径数是："+pre[n-1]);
    }
    /**
     * 优化2：节省空间，在优化1上改进，空间复杂度为n
     * @param m
     * @param n
     */
    public static void optUniquePaths2(int m,int n){
//        原地修改
        int[] cur=new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        System.out.println("优化2路径数是："+cur[n-1]);
    }
}
