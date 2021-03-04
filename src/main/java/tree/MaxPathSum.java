package tree;

/**
 * @author: suruomo
 * @date: 2021/3/4 9:56
 * @description: 124. 二叉树中的最大路径和
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 *
 * 路径和 是路径中各节点值的总和。
 *
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 */
public class MaxPathSum {
    /**
     *    节点定义
     */
    class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int maxSum=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root){
        maxGain(root);
        return maxSum;
    }

    /**
     * 节点root的最大贡献值
     * @param root
     * @return
     */
    private int maxGain(TreeNode root) {
        if (root==null){
            return 0;
        }
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain=Math.max(maxGain(root.left),0);
        int rightGain=Math.max(maxGain(root.right),0);
        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int newPath= root.val+leftGain+rightGain;
        // 更新答案
        maxSum=Math.max(maxSum,newPath);
        // 返回节点的最大贡献值
        return root.val+Math.max(leftGain,rightGain);
    }

}
