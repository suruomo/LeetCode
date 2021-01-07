package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
* @author: suruomo
* @date: 2021/1/7 11:08
* @description: 547. 省份数量
 * 有 n 个城市，其中一些彼此相连，另一些没有相连。
 * 如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。
 * 省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。
 * 给你一个 n x n 的矩阵 isConnected ，
 * 其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，
 * 而 isConnected[i][j] = 0 表示二者不直接相连。
 * 返回矩阵中 省份 的数量。
*/

public class FindCircleNum {
    /**
     * 1.dfs
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int nums=isConnected.length;
        boolean[] visited=new boolean[nums];
        int provinces=0;
        // 遍历每一个城市，如果该城市没有被访问，就以该城市为起点进行dfs，一次dfs后省份加一
        for (int i = 0; i < nums; i++) {
            if (!visited[i]){
                dfs(isConnected,visited,nums,i);
                provinces++;
            }
        }
        return provinces;
    }

    /**
     *
     * @param isConnected 连通矩阵
     * @param visited 是否访问数组
     * @param nums 城市数量
     * @param i 当前遍历城市
     */
    private void dfs(int[][] isConnected, boolean[] visited, int nums, int i) {
        for (int j = 0; j < nums; j++) {
            if (!visited[j]&&isConnected[i][j]==1){
                visited[j]=true;
                dfs(isConnected, visited, nums, j);
            }
        }
    }

    /**
     * 2.bfs
     * @param isConnected
     * @return
     */
    public int findCircleNum1(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < provinces; k++) {
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            queue.offer(k);
                        }
                    }
                }
                circles++;
            }
        }
        return circles;
    }
}
