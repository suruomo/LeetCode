package graph.toposort;

import java.util.*;

/**
 * 拓扑排序算法
 * @author 苏若墨
 */
public class ToPo {
    private List<Node> result;
    private Queue<Node> setZeroInDegree;
    private Graph graph;

    public ToPo(Graph graph) {
        this.graph = graph;
        result=new ArrayList<>();
        setZeroInDegree=new LinkedList<>();
        //遍历图中结点，将入度为0的结点加入队列setZeroInDegree中
        for(Node node:this.graph.getVertexSet()){
            if(node.getPathIn()==0){
                setZeroInDegree.add(node);
            }
        }
    }

    /**
     * 实现：
     * Kahn拓扑排序处理算法
     */
    public  void kahn(){
        //当入度为0的结点队列不为空时循环
        while (!setZeroInDegree.isEmpty()){
            //出队：返回一个入度为0的结点，加入结果集中
            Node node=setZeroInDegree.poll();
            result.add(node);
            //如果图的邻接结点集合为空，则遍历完返回
            if(this.graph.getAdjacentNode().keySet().isEmpty()){
                return;
            }
            //循环遍历当前结点node的邻接结点
            for(Node node1:this.graph.getAdjacentNode().get(node)){
                //当前邻接结点入度减一
                node1.setPathIn(node1.getPathIn()-1);
                //若当前邻接结点入度为0时，将其加入队列中
                if(node1.getPathIn()==0){
                    setZeroInDegree.add(node1);
                }
            }
            //从图的结点集合和邻接结点结合中删除当前结点node
            this.graph.getVertexSet().remove(node);
            this.graph.getAdjacentNode().remove(node);
        }
        if(!setZeroInDegree.isEmpty()){
            throw new IllegalArgumentException("图中有环！无法进行拓扑排序");
        }
    }

    /**
     * 返回结果集
     * @return
     */
    public Iterable<Node> getResult(){
        return result;
    }

}
