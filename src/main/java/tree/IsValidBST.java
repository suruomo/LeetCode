package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: suruomo
 * @date: 2020/9/24 10:07
 * @description: 98 判断一个二叉树是不是BST
 */
public class IsValidBST {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val=x;
        }
    }

    /**
     * 特性：BST中序遍历为有序的
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

}
