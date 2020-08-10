package tree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author suruomo
 * @date 2020/8/10 15:27
 * @description: 559 给定一个 N 叉树，找到其最大深度。
 */
public class NMaxDepth {
    /**
     * 结点定义
     */
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 递归求解：每个结点的最大深度为其孩子深度加1；
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            List<Integer> heights = new LinkedList<>();
            for (Node item : root.children) {
                heights.add(maxDepth(item));
            }
            return Collections.max(heights) + 1;
        }
    }
}
