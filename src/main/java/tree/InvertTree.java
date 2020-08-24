package tree;

/**
 * @Author: suruomo
 * @Date: 2020/8/24 16:03
 * @Description: 226 翻转二叉树
 */
public class InvertTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode  right;
        TreeNode(int x){
            val=x;
        }
    }
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }
}
