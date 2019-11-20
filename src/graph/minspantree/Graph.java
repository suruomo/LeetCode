package graph.minspantree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 最小生成树：Prim和Kruskal算法实现
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
     * 返回顶点ch在顶点集合中下标位置
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertex.length; i++) {
            if (vertex[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * prim最小生成树
     * <p>
     * 参数说明：
     * start -- 从图中的第start个元素开始，生成最小树
     */
    public void prim(int start) {
        // 顶点个数
        int num = vertex.length;
        // prim最小树的索引，即prim数组的索引
        int index = 0;
        // prim最小树的结果数组
        char[] prim = new char[num];
        // 顶点间边的权值
        int[] weights = new int[num];

        // prim最小生成树中第一个数是"图中第start个顶点"，因为是从start开始的。
        prim[index++] = vertex[start];

        // 初始化"顶点的权值数组"，
        // 将每个顶点的权值初始化为"第start个顶点"到"该顶点"的权值。
        for (int i = 0; i < num; i++) {
            weights[i] = matrix[start][i];
        }
        // 将第start个顶点的权值初始化为0。
        // 可以理解为"第start个顶点到它自身的距离为0"。
        weights[start] = 0;

        for (int i = 0; i < num; i++) {
            // 由于从start开始的，因此不需要再对第start个顶点进行处理。
            if (start == i) {
                continue;
            }
            int j;
            int minVertex = 0;
            int minWeight = INF;
            // 在未被加入到最小生成树的顶点中，找出权值最小的顶点。
            for (j = 0; j< num; j++) {
                // 若weights[j]=0，意味着"第j个节点已经被排序过"(或者说已经加入了最小生成树中)。
                if (weights[j] != 0 && weights[j] < minWeight) {
                    minWeight = weights[j];
                    minVertex = j;
                }
            }

            // 经过上面的处理后，在未被加入到最小生成树的顶点中，权值最小的顶点是第k个顶点。
            // 将第k个顶点加入到最小生成树的结果数组中
            prim[index++] = vertex[minVertex];
            // 将"第k个顶点的权值"标记为0，意味着第k个顶点已经排序过了(或者说已经加入了最小树结果中)。
            weights[minVertex] = 0;
            // 当第k个顶点被加入到最小生成树的结果数组中之后，更新其它顶点的权值。
            for (j = 0; j < num; j++) {
                // 当第j个节点没有被处理，并且需要更新时才被更新。
                if (weights[j] != 0 && matrix[minVertex][j] < weights[j]) {
                    weights[j] = matrix[minVertex][j];
                }
            }
        }

        // 计算最小生成树的权值
        int sum = 0;
        for (int i = 1; i < index; i++) {
            int min = INF;
            // 获取prim[i]在vertex中的位置
            int dex = getPosition(prim[i]);
            // 找出到j的权值最小的顶点。
            for (int j = 0; j < i; j++) {
                int m = getPosition(prim[j]);
                if (matrix[m][dex] < min) {
                    min = matrix[m][dex];
                }
            }
            sum += min;
        }

        // 打印最小生成树
        System.out.printf("PRIM(%c)=%d: ", vertex[start], sum);
        for (int i = 0; i < index; i++) {
            System.out.printf("%c ", prim[i]);
        }
        System.out.printf("\n");
    }


}

