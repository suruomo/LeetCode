package backtracking;

/**
 * @Author: suruomo
 * @Date: 2020/9/13 15:38
 * @Description: 79 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，
 * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Exist {
    public static void main(String[] args) {
        char[][] board= {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word="ABCB";
        System.out.println(exist(board,word));

    }

    /**
     *检查当前数组中是否存在该单词
     * @param board 二维字符数组
     * @param word 待搜索单词
     * @return
     */
    private static boolean exist(char[][] board, String word) {
        int h= board.length;
        int w= board[0].length;
        boolean[][] visited=new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j <w ; j++) {
                boolean flag=check(board,visited,i,j,word,0);
                if(flag){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 深度优先搜索
     * @param board 给定二维字符数组
     * @param visited 标识每个位置是否被访问过，防止重复访问
     * @param i 数组横坐标
     * @param j 数组纵坐标
     * @param word 待匹配字符串
     * @param k 搜索单词的第k位
     * @return
     */
    private static boolean check(char[][] board, boolean[][] visited, int i, int j, String word, int k) {
        if(board[i][j]!=word.charAt(k)){
            return false;
        }else if(k==word.length()-1){
            return true;
        }
        //1.当前位置已访问
        visited[i][j]=true;
        //2.dfs过程
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        //对当前位置的邻接位置进行下一个字符搜索
        for (int[] dir: directions) {
            int newi=dir[0]+i;
            int newj=dir[1]+j;
            if(newi>=0&&newi< board.length&&newj>=0&&newj< board.length){
                //如果当前新位置未访问，递归进行下一个字符匹配
                if (!visited[newi][newj]){
                    boolean flag=check(board,visited,newi,newj,word,k+1);
                    if(flag){
                        result=true;
                        break;
                    }
                }
            }

        }
        //3.取消当前位置访问
        visited[i][j]=false;
        return result;
    }
}
