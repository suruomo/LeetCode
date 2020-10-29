package tree;

/**
 * @author: suruomo
 * @date: 2020/10/29 10:07
 * @description: 129. 求根到叶子节点数字之和
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 */
public class SumNumbers {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    /**
     * 深度优先遍历
     * @param root 当前结点
     * @param preSum 从根节点到当前结点之前的数字之和
     * @return
     */
    private int dfs(TreeNode root, int preSum) {
        // 结束条件
        if (root==null){
            return 0;
        }
        // 计算加上当前结点的所有数字之和
        int sum=preSum*10+ root.val;
        // 到达根节点返回
        if (root.left==null&&root.right==null){
            return sum;
        }
        else {
            // 左子树加右子树的数字之和就是结果
            return dfs(root.left,sum)+dfs(root.right,sum);
        }
    }
}
