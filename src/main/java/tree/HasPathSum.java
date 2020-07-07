package tree;

/**
 * @author suruomo
 * @date 2020/7/7 17:08
 * @description: 112 给定一个二叉树和一个目标和，
 * 判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class HasPathSum {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }

    /**
     * 假定从根节点到当前节点的值之和为 val，我们可以将这个大问题转化为一个小问题：
     * 是否存在从当前节点的子节点到叶子的路径，满足其路径和为 sum - val。
     * 不难发现这满足递归的性质，若当前节点就是叶子节点，那么我们直接判断 sum 是否等于 val 即可
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root,int sum){
        if (root == null) {
            return false;
        }
        //叶子节点
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
