package interview;

import java.util.*;

/**
 * @author: suruomo
 * @date: 2021/6/7 10:21
 * @description: N皇后
 * N皇后问题是指在N*N的棋盘上要摆N个皇后，
 * 要求：任何两个皇后不同行，不同列也不再同一条斜线上，
 * 求给一个整数N，返回N皇后的摆法数。
 */
public class NQueens {
    public int Nqueen (int n) {
        // 结果集合
        List<List<String>> solutions = new ArrayList<List<String>>();
        // 记录每行放置的皇后的列下标
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        int count=0;
        Set<Integer> columns=new HashSet<>();
        // 左上右下
        Set<Integer> diagonals1=new HashSet<>();
        // 右上左下
        Set<Integer> diagonals2=new HashSet<>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions.size();
    }

    public void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        // 遍历到最后一行，求得一个解
        if (row == n) {
            // 转变结果
            List<String> board = generateBoard(queens, n);
            // 加入结果集
            solutions.add(board);
        } else {
            // 遍历当前行的每一列
            for (int i = 0; i < n; i++) {
                // 判断每个位置相对的三个集合是否包含皇后
                if (columns.contains(i)) {
                    continue;
                }
                // 该斜线上的每个位置满足：行下标与列下标之差相等
                // 因此判断集合中是否包含该差值
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                // 该斜线的每个位置满足：行下标与列下标之和相等
                // 因此判断集合中是否包含该和值
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }
                // 1. 选择
                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                // 2.回溯下一行
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                // 3.取消当前选择
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    private List<String> generateBoard(int[] queens, int n) {
        List<String> lists=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars=new char[n];
            Arrays.fill(chars,',');
            chars[queens[i]]='Q';
            lists.add(chars.toString());
        }
        return lists;
    }
}
