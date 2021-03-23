package huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author: suruomo
 * @date: 2021/3/23 9:59
 * @description:
 */
public class Maze {
    private static Stack<String> path=new Stack<>();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int rows=Integer.valueOf(sc.next());
            int columns=Integer.valueOf(sc.next());
            int[][] arr=new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    arr[i][j]=Integer.valueOf(sc.next());
                }
            }
            dfs(arr,0,0);
        }
    }
    /**
     * dfs
     * @param arr
     * @param i
     * @param j
     */
    private static void dfs(int[][] arr, int i, int j) {
        arr[i][j]=1;
        path.push("(" + i + "," + j + ")");
        // 结束条件
        if (i==arr.length-1&&j==arr[0].length-1){
            for (String s: path) {
                System.out.println(s);
            }
        }
        // 下一层遍历
        if (i+1<arr.length&&arr[i+1][j]==0){
            dfs(arr, i+1, j);
        }
        if (j+1<arr[0].length&&arr[i][j+1]==0){
            dfs(arr, i, j+1);
        }
        arr[i][j]=0;
        path.pop();
    }
}
