package graph.minspantree;

/**
 * 最小生成树Prim和Kruskal算法实现
 *
 * @author 苏若墨
 */
public class Graph {
    /**
     * 边的数量
     */
    private int edgeNum=0;
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
        //统计边,矩阵对称
        for (int i = 0; i < vertex.length; i++) {
            for (int j = i+1; j < vertex.length; j++) {
                if (matrix[i][j]!=INF) {
                    edgeNum++;
                }
            }
        }
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
     * Prim最小生成树
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
        //最小生成树权值
        int sum=0;
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
            //更新权值
          sum+=minWeight;
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
        // 打印最小生成树
        System.out.printf("PRIM(%c)=%d: ", vertex[start], sum);
        for (int i = 0; i < index; i++) {
            System.out.printf("%c ", prim[i]);
        }
        System.out.printf("\n");
    }
    /**
     * 边的结构体
     */
    private static class EData{
        char start; // 边的起点
        char end;   // 边的终点
        int weight; // 边的权重

        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    /**
     * 对边按照权值大小进行排序(由小到大)
     */
    private void sortEdges(EData[] edges, int length) {
        for (int i=0; i<length; i++) {
            for (int j=i+1; j<length; j++) {
                if (edges[i].weight > edges[j].weight) {
                    // 交换"边i"和"边j"
                    EData tmp = edges[i];
                    edges[i] = edges[j];
                    edges[j] = tmp;
                }
            }
        }
    }
    /**
     * 获取i的终点(重要！！！）
     */
    private int getEnd(int[] vends, int i) {
        while (vends[i] != 0) {
            i = vends[i];
        }
        return i;
    }
    /**
     * 获取图中的边
     */
    private EData[] getEdges() {
        int index=0;
        EData[] edges = new EData[edgeNum];
        for (int i=0; i < vertex.length; i++) {
            for (int j=i+1; j < vertex.length; j++) {
                if (matrix[i][j]!=INF) {
                    edges[index++] = new EData(vertex[i], vertex[j], matrix[i][j]);
                }
            }
        }
        return edges;
    }

    /**
     * 克鲁斯卡尔（Kruskal)最小生成树
     */
    public void kruskal() {
        // 结果数组的索引
        int index = 0;
        // 用于保存"已有最小生成树"中每个顶点在该最小树中的终点。
        int[] vends = new int[edgeNum];
        // 结果数组，保存kruskal最小生成树的边
        EData[] rets = new EData[edgeNum];
        // 获取"图中所有的边"
        EData[] edges = getEdges();
        //最小权值
        int sum=0;
        // 1.将边按照"权"的大小进行排序(从小到大)
        sortEdges(edges, edgeNum);

        for (int i=0; i<edgeNum; i++) {
            // 获取第i条边的"起点"的序号
            int p1 = getPosition(edges[i].start);
            // 获取第i条边的"终点"的序号
            int p2 = getPosition(edges[i].end);
            // 获取p1在"已有的最小生成树"中的终点
            int m = getEnd(vends, p1);
            // 获取p2在"已有的最小生成树"中的终点
            int n = getEnd(vends, p2);
            // 如果m!=n，意味着"边i"与"已经添加到最小生成树中的顶点"没有形成环路
            if (m != n) {
                // 设置m在"已有的最小生成树"中的终点为n
                vends[m] = n;
                // 保存结果
                rets[index++] = edges[i];
                sum+=edges[i].weight;
            }
        }
        System.out.printf("Kruskal=%d: ", sum);
        for (int i = 0; i < index; i++) {
            System.out.printf("(%c,%c) ", rets[i].start, rets[i].end);
        }
    }
}

