package graph.traversing;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 图的DFS和BFS实现
 *
 * @author 苏若墨
 */
public class Graph {
    /**
     * 顶点集合
     */
    private char[] vertex;
    /**
     * 邻接矩阵
     */
    private int[][] matrix;
    /**
     * 最大值，表示两个顶点之间不连通
     */
    private static final int INF = Integer.MAX_VALUE;

    /**
     * 用提供的顶点和邻接矩阵创建图
     *
     * @param vertex
     * @param matrix
     */
    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    /**
     * 返回顶点vertex的第一个邻接顶点的索引，失败返回-1
     *
     * @param vertex
     * @return
     */
    public int firstVertex(int vertex) {
        if (vertex < 0 || vertex > (this.vertex.length - 1)) {
            return -1;
        }
        for (int i = 0; i < this.vertex.length; i++) {
            if (this.matrix[vertex][i] != 0 && this.matrix[vertex][i] != INF) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 返回顶点vertex相对于它的一个邻接顶点index的下一个邻接顶点索引
     *
     * @param vertex
     * @return
     */
    public int nextVertex(int vertex, int index) {
        if (vertex < 0 || vertex > (this.vertex.length - 1) || index < 0 || index > (this.vertex.length - 1)) {
            return -1;
        }
        for (int i = index + 1; i < this.vertex.length; i++) {
            if (this.matrix[vertex][i] != 0 && this.matrix[vertex][i] != INF) {
                return i;
            }
        }
        return -1;
    }

    /**
     * DFS:深度优先遍历递归版
     *
     * @param i 待访问的当前结点
     * @param visited 该结点是否被访问
     */
    public void DFS(int i, boolean[] visited) {
        //标记当前顶点以访问
        visited[i] = true;
        System.out.print(vertex[i] + "-->");
        //遍历该顶点的邻接顶点，若是没有访问过，继续往下遍历
        for (int index = firstVertex(i); index >= 0; index = nextVertex(i, index)) {
            if (!visited[index]) {
                DFS(index, visited);
            }
        }
    }

    /**
     * DFS:深度优先遍历非递归版
     */
    public void DFS() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[this.vertex.length];
        //开始顶点入栈，标记已访问
        stack.push(0);
        visited[0] = true;
        while (!stack.isEmpty()) {
            int current = stack.pop();
            System.out.print(vertex[current] + "-->");
            for (int i = 0; i < this.vertex.length; i++) {
                if (!visited[i] && matrix[current][i] != INF && matrix[current][i] != 0) {
                    visited[i] = true;
                    stack.push(i);
                    break;
                }
            }

        }
    }



    /**
     * 广度优先遍历算法 Breadth-first search（非递归）
     */
    public void BFS() {
        // LinkedList实现了Queue接口 FIFO
        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited=new boolean[vertex.length];
        for (int i = 0; i < vertex.length; i++) {
            visited[i] = false;
        }

        //这个循环是为了确保每个顶点都被遍历到
        for (int i = 0; i < vertex.length; i++) {
            if (!visited[i]) {
                queue.add(i);
                visited[i] = true;
                System.out.print(vertex[i] + "-->");
                while (!queue.isEmpty()) {
                    int row = queue.remove();
                    for (int k = firstVertex(row); k >= 0; k = nextVertex(row, k)) {
                        if (!visited[k]) {
                            queue.add(k);
                            visited[k] = true;
                            System.out.print(vertex[k] + "-->");
                        }
                    }

                }
            }
        }
    }


}

