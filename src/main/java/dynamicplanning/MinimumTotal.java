package dynamicplanning;

import java.util.List;

/**
 * @author suruomo
 * @date 2020/7/14 14:17
 * @description: 120 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 */
public class MinimumTotal {
    /**
     *  f[i][j]表示从三角形顶部走到位置 (i, j)的最小路径和
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle){
        int n=triangle.size();
        int[][] f=new int[n][n];
        f[0][0]=triangle.get(0).get(0);
        for(int i=1;i<n;i++){
            //1.每一行最右边的位置，只能从直上方走下来
            f[i][0]=f[i-1][0]+triangle.get(i).get(0);
            //2.除去最左最右中间为位置
            for(int j=1;j<i;j++){
                f[i][j]=Math.min(f[i-1][j-1]+triangle.get(i).get(j),f[i-1][j]+triangle.get(i).get(j));
            }
            //3.最左边的位置，只能从右上角下来
            f[i][i]=f[i-1][i-1]+triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        //找底边最小值返回
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }
}
