package interview;

/**
 * @author: suruomo
 * @date: 2021/6/20 15:56
 * @description: 矩阵乘法
 * 给定两个n*n的矩阵A和B，求A*B。
 */
public class MatrixMultiply {
    public int[][] solve (int[][] a, int[][] b) {
        int arows=a.length;
        int acolsbrows=a[0].length;
        int bcols=b[0].length;
        int[][] ans=new int[arows][bcols];
        for (int i = 0; i < arows; i++) {
            for (int j = 0; j < bcols; j++) {
                int t=0;
                for (int k = 0; k < acolsbrows; k++) {
                    t+=a[i][k]*b[k][j];
                }
                ans[i][j]=t;
            }
        }
        return ans;
    }
}
