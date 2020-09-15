package tree;

/**
 * @Author: suruomo
 * @Date: 2020/9/15 10:18
 * @Description: 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 */
public class ConvertBST {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val=x;
        }
    }
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }
}
