package tree;

/**
 * @author: suruomo
 * @date: 2020/9/27 10:48
 * @description: 235 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 二叉搜索树性质
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            // 如果当前节点的值大于 p 和 q 的值，
            // 说明 p 和 q 应该在当前节点的左子树，因此将当前节点移动到它的左子节点；
            // 如果当前节点的值小于 p 和 q 的值，
            // 说明 p 和 q 应该在当前节点的右子树，因此将当前节点移动到它的右子节点；
            // 否则当前结点就是该公共祖先
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
}
