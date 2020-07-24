package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suruomo
 * @date 2020/7/24 16:10
 * @description: 872 叶子相似的树，如果两棵树的叶子序列相同返回true，否则返回false
 */
public class LeafSimilar {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode  right;
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList();
        List<Integer> leaves2 = new ArrayList();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    public void dfs(TreeNode node, List<Integer> leafValues) {
        if (node != null) {
            //如果当前节点是叶子节点，加入list
            if (node.left == null && node.right == null) {
                leafValues.add(node.val);
            }
            dfs(node.left, leafValues);
            dfs(node.right, leafValues);
        }
    }
}
