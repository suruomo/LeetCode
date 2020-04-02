package graph;

/**
 * @author 苏若墨
 */
public class Dijkstra {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] weight = {
                {0,3,2000,7,9999999},
                {3,0,4,2,9999999},
                {9999999,4,0,5,6},
                {7,2,5,0,4},
                {9999999,9999999,4,6,0}
        };
       //求0号顶点到图中其他顶点的最短路径
        int[] path = dijsktra(weight,0);
        for(int i = 0;i < path.length;i++) {
            System.out.print(path[i] + "  ");
        }
    }

    /**
     * Dijkstra算法实现
     * @param weight 图的邻接矩阵
     * @param start 开始顶点下标
     * @return  返回从开始下标到其他顶点最短路径数组，shortPath[i]表示从start到i的最短路径
     */
    public static int[] dijsktra(int[][] weight, int start){
        //顶点个数
        int n = weight.length;
        //存放从start到其他各点的最短路径
        int[] shortPath = new int[n];
        //标记当前该顶点的最短路径是否已经求出,1表示已求出
        int[] visited = new int[n];

        //初始化，第一个顶点求出
        shortPath[start] = 0;
        visited[start] = 1;
        //要加入n-1个顶点
        for(int count = 1;count <= n - 1;count++)
        {
            //选出一个距离初始顶点start最近的未标记顶点
            int k = -1;
            int min = 1000;
            for(int i = 0;i < n;i++)
            {
                if(visited[i] == 0 && weight[start][i] < min)
                {
                    min = weight[start][i];
                    k = i;
                }
            }

            //将新选出的顶点标记为已求出最短路径，且到start的最短路径就是dmin
            shortPath[k] = min;
            visited[k] = 1;

            //以k为中间点，修正从start到未访问各点的距离
            for(int i = 0;i < n;i++)
            {
                if(visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]) {
                    weight[start][i] = weight[start][k] + weight[k][i];
                }
            }

        }

        return shortPath;
    }
}