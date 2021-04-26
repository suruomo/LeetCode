package interview;

/**
 * @author: suruomo
 * @date: 2021/4/26 10:10
 * @description: 给定一个二叉树和一个值sum，判断是否有从根节点到叶子节点的节点值之和等于sum 的路径，
 */
public class HasPathSum {
    public class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode right=null;
    }
    public boolean hasPathSum (TreeNode root, int sum) {
     if (root==null){
         return false;
     }
     return preOrder(root,sum,0);
    }

    private boolean preOrder(TreeNode root, int sum, int cur) {
        if (root==null){
            return false;
        }
        cur+= root.val;
        if (root.left==null&&root.right==null&&cur==sum){
            return true;
        }
        return preOrder(root.left,sum,cur)||preOrder(root.right,sum,cur);
    }
}
