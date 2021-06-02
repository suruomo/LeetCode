package interview;

/**
 * @author: suruomo
 * @date: 2021/6/2 16:53
 * @description: 给定一个由0和1组成的2维矩阵，返回该矩阵中最大的由1组成的正方形的面积
 */
public class MaxSquare {
    public int solve (char[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return 0;
        }
        int maxSide=0;
        int rows=matrix.length;
        int columns=matrix[0].length;
        int[][] dp=new int[rows][columns];
        for (int i = 0; i <rows ; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j]=='1'){
                    if (i==0||j==0){
                        dp[i][j]=1;
                    }else {
                        dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    }
                    maxSide=Math.max(dp[i][j],maxSide);
                }
            }
        }
        return maxSide*maxSide;
    }
}
