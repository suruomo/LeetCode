package bfs_dfs;

/**
 * @author: suruomo
 * @date: 2021/1/6 15:04
 * @description: 130. 被围绕的区域
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。
 */
public class Solve {
    private int row,col;

    public void solve(char[][] board) {
        row= board.length;
        if (row==0){
            return;
        }
        col= board[0].length;
        // 将边界的O以及和边界相连的O标记为A,表示不会被填充为X
        // 1.标记左右边界两列
        for (int i = 0; i < row; i++) {
            dfs(board,i,0);
            dfs(board,i,col-1);
        }
        // 2.标记上下边界两行
        for (int i = 1; i < col-1; i++) {
            dfs(board,0,i);
            dfs(board,row-1,i);
        }
        // 3.遍历每个位置判断
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j]=='A'){
                    board[i][j]='O';
                }else if (board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }

    /**
     * dfs标记过程
     * @param board
     * @param x 行索引
     * @param y 列索引
     */
    private void dfs(char[][] board, int x, int y) {
        if (x<0||x>=row||y<0||y>=col||board[x][y]!='O'){
            return;
        }
        // 将边界或者边界相连的O标记为A
        board[x][y]='A';
        dfs(board,x+1,y);
        dfs(board,x-1,y);
        dfs(board,x,y+1);
        dfs(board,x,y-1);
    }
}
