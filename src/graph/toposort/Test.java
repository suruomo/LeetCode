package graph.toposort;

/**
 * @author 苏若墨
 */
public class Test {
    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");

        Graph graph = new Graph();
        graph.addNode(A, B);
        graph.addNode(B, C);
        graph.addNode(B, D);
        graph.addNode(D, C);
        graph.addNode(E, C);
        graph.addNode(C, F);

        ToPo toPo=new ToPo(graph);
        toPo.kahn();
        for(Node temp : toPo.getResult()){
            System.out.print(temp.getVal().toString() + "-->");
        }

    }
}
