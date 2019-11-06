package graph.toposort;

/**
 * 拓扑排序结点类
 * @author 苏若墨
 */
public class Node {
    /**
     * 结点值
     */
    private Object val;
    /**
     * 入链路数量
     */
    private int pathIn=0;

    public Node(Object val) {
        this.val = val;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }

    public int getPathIn() {
        return pathIn;
    }

    public void setPathIn(int pathIn) {
        this.pathIn = pathIn;
    }
}
