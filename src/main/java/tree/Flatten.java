package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2020/9/18 10:10
 * @description: 114. 二叉树展开为链表
 * 给定一个二叉树，原地将它展开为一个单链表。
 */

public class Flatten {
    /**
     * 结点类
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        //修改为单链表
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    /**
     *前序遍历，将结果保存在list中
     * @param root
     * @param list
     */
    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}
