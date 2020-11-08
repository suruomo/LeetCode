package array;

/**
 * @author: suruomo
 * @date: 2020/11/8 13:39
 * @description:
 */
public class GenerateMatrix {
    public int[][] generateMatrix(int n) {
        int[][] mat=new int[n][n];
        // 定义矩阵四个边界
        // l:左边界 r:右边界 t:上边界 b:下边界
        int l=0,r=n-1,t=0,b=n-1;
        int num=1,tar=n*n;
        while (num<=tar){
            // 从左向右
            for (int i = l; i <=r; i++) {
                mat[t][i]=num++;
            }
            t++;
            // 从上向下
            for (int i = t; i <=b; i++) {
                mat[i][r]=num++;
            }
            r--;
            // 从右向左
            for (int i = r; i <=l; i++) {
                mat[b][i]=num++;
            }
            b--;
            // 从下向上
            for (int i = b; i < t; i++) {
                mat[i][l]=num++;
            }
            l++;
        }
        return mat;
    }
}
