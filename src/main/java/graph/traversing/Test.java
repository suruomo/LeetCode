package graph.traversing;

/**
 * @author 苏若墨
 */
public class Test {
    public static void main(String[] args) {
        final int INF = Integer.MAX_VALUE;
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = {
                /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        boolean[] visited=new boolean[vertex.length];
        Graph graph=new Graph(vertex,matrix);
        System.out.println("DFS递归遍历：");
        graph.DFS(0,visited);
        System.out.println();
        System.out.println("DFS非递归遍历：");
        graph.DFS();
        System.out.println();
        System.out.println("BFS遍历：");
        graph.BFS();
    }
}
