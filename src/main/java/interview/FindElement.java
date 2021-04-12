package interview;

/**
 * @author: suruomo
 * @date: 2021/4/12 13:07
 * @description:
 * 已知int一个有序矩阵mat，同时给定矩阵的大小n和m以及需要查找的元素x，
 * 且矩阵的行和列都是从小到大有序的。
 * 设计查找算法返回所查找元素的二元数组，代表该元素的行号和列号(均从零开始)。保证元素互异。
 */
public class FindElement {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        int i=0;
        int j=m-1;
        while (i<n&&i>=0&&j<m&&j>=0){
            if (mat[i][j]==x){
                return new int[]{i,j};
            }else if (mat[i][j]>x){
                j--;
            }else {
                i++;
            }
        }
        return new int[2];
    }
}
