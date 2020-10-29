package dynamicplanning;

/**
 * @author: suruomo
 * @date: 2020/10/29 10:55
 * @description: 221. 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
// 最大正方形边长
        int maxSide=0;
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return maxSide;
        }
        // 行数、列数
        int rows= matrix.length;
        int columns= matrix[0].length;
        // dp[i][j]表示以(i,j)为右下角，可以返回的只包含1的正边形最大边长
        int[][] dp=new int[rows][columns];
        for (int i=0;i<rows;i++){
            for (int j=0;j<columns;j++){
                if (matrix[i][j]=='1'){
                    if (i==0||j==0){
                        dp[i][j]=1;
                    }
                    else {
                        dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }
                    maxSide=Math.max(maxSide,dp[i][j]);
                }
            }
        }
        int maxSquare=maxSide*maxSide;
        return maxSquare;
    }
}
