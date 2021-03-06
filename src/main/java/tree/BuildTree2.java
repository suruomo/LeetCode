package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: suruomo
 * @date: 2020/10/9 11:02
 * @description: 105 从前序与中序遍历序列构造二叉树
 */
public class BuildTree2 {
    /**
     * 结点类
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 构造中序遍历数组的hash映射，快速找到结点的索引
     */
    private Map<Integer, Integer> indexMap;

    /**
     * 递归构造树结点
     * @param preorder 前序遍历数组
     * @param inorder 中序遍历数组
     * @param preorder_left
     * @param preorder_right
     * @param inorder_left
     * @param inorder_right
     * @return
     */
    public TreeNode myBuildTree(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {
        if (preorder_left > preorder_right) {
            return null;
        }

        // 1.前序遍历中的第一个节点就是根节点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);

        // 先把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树中的节点数目
        int size_left_subtree = inorder_root - inorder_left;
        // 2.递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = myBuildTree(preorder, inorder, preorder_left + 1, preorder_left + size_left_subtree, inorder_left, inorder_root - 1);
        // 3.递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = myBuildTree(preorder, inorder, preorder_left + size_left_subtree + 1, preorder_right, inorder_root + 1, inorder_right);
        return root;
    }

    /**
     * 1.方法一
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    /**
     * 2.方法二
     * @param preOrder
     * @param inOrder
     * @return
     */
    public TreeNode buildTree1(int[] preOrder, int[] inOrder) {
        if (preOrder == null || preOrder.length == 0) {
            return null;
        }

        int val = preOrder[0], pos = 0, len = preOrder.length;
        TreeNode root = new TreeNode(val);

        // 找到中序数组中根节点位置
        for(; pos < len; pos++){
            if (inOrder[pos] == val) {
                break;
            }
        }
        // 左右子树继续拆分，递归重构
        // 此处 Arrays.copyOfRange 方法起点为 len 不抛异常，返回[]，对应递归结束条件。
        root.left = buildTree1(Arrays.copyOfRange(preOrder, 1, pos + 1),
                Arrays.copyOfRange(inOrder, 0, pos));
        root.right = buildTree1(Arrays.copyOfRange(preOrder, pos + 1, len),
                Arrays.copyOfRange(inOrder, pos + 1, len));

        return root;
    }
}
