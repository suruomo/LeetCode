package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: suruomo
 * @date: 2020/9/25 10:39
 * @description: 106 根据中序后序遍历构造二叉树
 */
public class BuildTree {
    /**
     * 结点类
     */
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode  right;
        TreeNode(int x){
            val=x;
        }
    }
    int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    /**
     * 递归函数
     * @param in_left 当前递归到中序序列中当前子树的左边界
     * @param in_right 当前递归到中序序列中当前子树的右边界
     * @return
     */
    public TreeNode helper(int in_left, int in_right) {
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode root = new TreeNode(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 根据后序规则，需要先构造右子树
        root.right = helper(index + 1, in_right);
        // 构造左子树
        root.left = helper(in_left, index - 1);
        return root;
    }

    /**
     * 构建二叉树
     * @param inorder 中序遍历数组
     * @param postorder 后序遍历数组
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 为中序数组建立（元素，下标）键值对的哈希表，便于查找左右子树
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }

        return helper(0, inorder.length - 1);
    }

}
