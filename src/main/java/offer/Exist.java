package offer;

/**
 * @author: suruomo
 * @date: 2021/1/4 10:43
 * @description: 剑指 Offer 12. 矩阵中的路径
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        char[] words=word.toCharArray();
        // 可以从矩阵的任意一个格子开始
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board,words,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先搜索+剪枝
     * @param board 矩阵
     * @param words 字符数组
     * @param i 行索引
     * @param j 列索引
     * @param k 当前搜索字符索引
     * @return
     */
    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        // 终止条件1
        // 1.行、列索引超出范围
        // 2.矩阵当前字符不是待搜索字符
        if (i> board.length||i<0||j> board[0].length||j<0||board[i][j]!= words[k]){
            return false;
        }
        // 终止条件2：找到一条字符路径返回true
        if (k== words.length-1){
            return true;
        }
        // 修改当前字符，相当于已搜索过
        board[i][j]='\0';
        // 递归过程
        boolean res=dfs(board,words,i+1,j,k+1)||dfs(board,words,i-1,j,k+1)||
                dfs(board,words,i,j+1,k+1)||dfs(board,words,i,j-1,k+1);
        // 将当前字符改回去
        board[i][j]=words[k];
        return res;
    }
}
