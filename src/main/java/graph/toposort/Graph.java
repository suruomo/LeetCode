package graph.toposort;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 拓扑图类
 * @author 苏若墨
 */
public class Graph {
    /**
     * 图中结点集合
     */
    private Set<Node> vertexSet=new HashSet<>();
    /**
     * 相邻结点结合，记录边
     */
    private Map<Node,Set<Node>> adjacentNode=new HashMap<>();

    /**
     * 将结点加入图中
     * @param start 出边结点
     * @param end  入边结点
     * @return  成功添加返回true,否则返回false
     */
    public boolean addNode(Node start,Node end){
        //加入图中结点集合
        if(!vertexSet.contains(start)){
            vertexSet.add(start);
        }
        if(!vertexSet.contains(end)){
            vertexSet.add(end);
        }
        //如果已经加入邻接结点集合，返回false
        if(adjacentNode.containsKey(start)&&adjacentNode.get(start).contains(end)){
            return false;
        }
        //如果存在键start,则在键start对应的邻接结点结合里加入end结点
        if(adjacentNode.containsKey(start)){
            adjacentNode.get(start).add(end);
        }
        //否则创建新的映射关系
        else{
            Set<Node> nodes=new HashSet<>();
            nodes.add(end);
            adjacentNode.put(start,nodes);
        }
        //入边结点的入边数加一
        end.setPathIn(end.getPathIn()+1);
        return true;
    }

    public Set<Node> getVertexSet() {
        return vertexSet;
    }

    public void setVertexSet(Set<Node> vertexSet) {
        this.vertexSet = vertexSet;
    }

    public Map<Node, Set<Node>> getAdjacentNode() {
        return adjacentNode;
    }

    public void setAdjacentNode(Map<Node, Set<Node>> adjacentNode) {
        this.adjacentNode = adjacentNode;
    }
}
