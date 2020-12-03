package offer;

import java.util.Stack;

/**
 * @author: suruomo
 * @date: 2020/12/3 13:15
 * @description: 剑指 Offer 27. 二叉树的镜像
 */
public class MirrorTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode  right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null){
            return null;
        }
        TreeNode leftRoot = mirrorTree(root.right);
        TreeNode rightRoot = mirrorTree(root.left);
        root.left = leftRoot;
        root.right = rightRoot;
        return root;
    }

    /**
     * 迭代版
     * @param root
     * @return
     */
    public TreeNode mirrorTree1(TreeNode root) {
        if(root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) {
                stack.add(node.left);
            }
            if(node.right != null) {
                stack.add(node.right);
            }
            //交换左右两个结点
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
