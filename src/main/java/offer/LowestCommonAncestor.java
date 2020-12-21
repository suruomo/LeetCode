package offer;

/**
 * @author: suruomo
 * @date: 2020/12/18 13:50
 * @description: 剑指 O ffer 68 - I. 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode  right;
    }

    /**
     * 迭代
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null) {
            // p,q 都在 root 的右子树中
            if(root.val < p.val && root.val < q.val)
            {
                root = root.right; // 遍历至右子节点
            } else if(root.val > p.val && root.val > q.val) // p,q 都在 root 的左子树中
            {
                root = root.left; // 遍历至左子节点
            } else {
                break;
            }
        }
        return root;
    }

    /**
     * 递归
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val<q.val&&root.val<p.val){
            lowestCommonAncestor1(root.right,p,q);
        }
        if (root.val>q.val&&root.val>p.val){
            lowestCommonAncestor1(root.left,p,q);
        }
        return root;
    }
}
