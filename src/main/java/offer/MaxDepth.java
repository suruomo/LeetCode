package offer;

/**
 * @author suruomo
 * @date 2020/7/22 15:37
 * @description: 剑指offer 55 二叉树的深度
 */
public class MaxDepth {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode  right;
    }
    public int maxDepth(TreeNode root){
        if(root!=null){
            int left=maxDepth(root.left);
            int right=maxDepth(root.right);
            return (left>right?left:right)+1;
        }
        return 0;
    }

}
