package bfs_dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: suruomo
 * @date: 2020/12/3 10:58
 * @description: 200. 岛屿数量
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 */
public class NumIsLands {
    /**
     * 1.DFS解法
     * @param grid
     * @return
     */
    public int numOfDfs(char[][] grid) {
        if(grid==null||grid.length==0){
            return 0;
        }
        int nr= grid.length;
        int nc=grid[0].length;
        int num_islands=0;
        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c] == '1') {
                    num_islands++;
                    dfs(grid,r,c);
                }
            }
        }
        return num_islands;
    }

    /**
     * 如果一个位置为 1，则以其为起始节点开始进行深度优先搜索。
     * 在深度优先搜索的过程中，每个搜索到的 1 都会被重新标记为 0。
     * @param grid
     * @param r
     * @param c
     */
    private void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if (r<0||c<0||r>=nr||c>=nc||grid[r][c]=='0'){
            return;
        }
        grid[r][c]='0';
        dfs(grid,r-1,c);
        dfs(grid,r+1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    }

    /**
     * 2.BFS解法
     * @param grid
     * @return
     */
    public int numOfBfs(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; r++) {
            for (int c = 0; c < nc; c++) {
                if (grid[r][c]=='1'){
                    num_islands++;
                    grid[r][c]='0';
                    Queue<Integer> queue=new LinkedList<>();
                    queue.add(r*nc+c);
                    while (!queue.isEmpty()){
                        int id = queue.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            queue.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            queue.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            queue.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            queue.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }
        return num_islands;
    }
}
