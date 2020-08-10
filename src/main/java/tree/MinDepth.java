package tree;

/**
 * @author suruomo
 * @date 2020/8/10 15:40
 * @description: 111 二叉树的最小深度
 */
public class MinDepth {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode  right;
        TreeNode(int x){
            val=x;
        }
    }
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        //找到左边最小深度
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        //全树最小深度
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }
}
