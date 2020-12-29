package offer;

/**
 * @author: suruomo
 * @date: 2020/12/18 13:50
 * @description: 剑指 O ffer 68 - II. 二叉树的最近公共祖先
 */
public class LowestCommonAncestor1 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode  right;
    }

    /**
     * 递归
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1.终止条件
        if(root == null || root == p || root == q) {
            return root;
        }
        // 2.递归
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // 3.返回值
        // p,q 都不在 root 的左子树中，直接返回 right
        if(left == null) {
            return right;
        }
        // p,q 都不在 root 的右子树中，直接返回 left
        if(right == null) {
            return left;
        }
        // left和right同时不为空 ：说明p, q分列在root的异侧，因此 root 为最近公共祖先，返回root
        return root;

    }
}
