package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: suruomo
 * @date: 2021/1/19 11:23
 * @description: 剑指 Offer 13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class MovingCount {
    /**
     * 1.BFS
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount(int m, int n, int k) {
        if(k==0){
            return 1;
        }
        // 向右和向下遍历的方向数组
        int[] dx={0,1};
        int[] dy={1,0};
        Queue<int[]> queue=new LinkedList<>();
        // 结果
        int ans=1;
        // 是否遍历标记数组
        boolean[][] visited=new boolean[m][n];
        // 初始化
        queue.offer(new int[]{0,0});
        visited[0][0]=true;
        while (!queue.isEmpty()){
            int[] temp=queue.poll();
            int x= temp[0];
            int y= temp[1];
            // 向右和向下遍历
            for (int i = 0; i < 2; i++) {
                int tx=dx[i]+x;
                int ty=dy[i]+y;
                // 剪枝
                if (tx<0||tx>=m||ty<0||ty>=n||visited[tx][ty]||get(tx)+get(ty)>k){
                    continue;
                }
                queue.offer(new int[]{tx,ty});
                visited[tx][ty]=true;
                ans++;
            }
        }
        return ans;
    }

    /**
     * 获取x的数位之和
     * @param x
     * @return
     */
    private int get(int x) {
        int res=0;
        while (x!=0){
            res+=x%10;
            x/=10;
        }
        return res;
    }

    /**
     * 2.DFS
     * @param m
     * @param n
     * @param k
     * @return
     */
    public int movingCount1(int m, int n, int k) {
        boolean[][] visited=new boolean[m][n];
        return dfs(0,0,m,n,k,visited);
    }

    /**
     * dfs过程
     * @param i 当前x坐标
     * @param j 当前y坐标
     * @param m
     * @param n
     * @param k
     * @param visited
     * @return
     */
    private int dfs(int i, int j, int m, int n, int k, boolean[][] visited) {
        // 获取数位和
        int tx=get(i);
        int ty=get(j);
        boolean flag=i<0||i>=m||j<0||j>=n||tx+ty>k||visited[i][j];
        if (flag){
            return 0;
        }
        visited[i][j]=true;
        return 1+dfs(i+1,j,m,n,k,visited)+dfs(i,j+1,m,n,k,visited);
    }
}
