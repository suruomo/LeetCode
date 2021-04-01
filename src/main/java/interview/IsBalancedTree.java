package interview;

/**
 * @author: suruomo
 * @date: 2021/4/1 11:46
 * @description: 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalancedTree {
    public class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode right=null;
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        return depth(root)!=-1;
    }

    private int depth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftDepth=depth(root.left);
        if (leftDepth==-1){
            return -1;
        }
        int rightDepth=depth(root.right);
        if (rightDepth==-1){
            return -1;
        }
        if (Math.abs(leftDepth-rightDepth)>1){
            return -1;
        }
        return Math.max(leftDepth,rightDepth)+1;
    }
}
