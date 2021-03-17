package offer;

import java.util.HashMap;

/**
 * @author: suruomo
 * @date: 2020/12/29 10:45
 * @description: 剑指 Offer 07. 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class BuildTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode  right;
        TreeNode(int x){
            val=x;
        }
    }

    /**
     * 存放中序遍历数组中结点值和索引的映射
     */
    private HashMap<Integer,Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n= inorder.length;
        indexMap=new HashMap<>();
        // 存放中序遍历数组中结点值和索引的映射
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i],i);
        }
        return build(preorder,inorder,0,n-1,0,n-1);
    }

    /**
     * 递归建树
     * @param preorder 前序遍历数组
     * @param inorder 中序遍历数组
     * @param pre_left 当前遍历区间的前序左边界
     * @param pre_right 当前遍历区间的前序右边界
     * @param in_left 当前遍历区间的中序左边界
     * @param in_right 当前遍历区间的中序右边界
     * @return
     */
    private TreeNode build(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        // 终止条件
        if (pre_left>pre_right){
            return null;
        }
        // 1.确定根节点
        int pre_root=pre_left;
        int in_root=indexMap.get(preorder[pre_root]);
        TreeNode root=new TreeNode(preorder[pre_root]);
        // 左子树个数
        int left_sub_size=in_root-in_left;
        // 2.左子树递归
        root.left=build(preorder,inorder,pre_left+1,pre_left+left_sub_size,in_left,in_root-1);
        // 3.右子树递归
        root.right=build(preorder,inorder,pre_left+left_sub_size+1,pre_right,in_root+1,in_right);
        return root;
    }
}
