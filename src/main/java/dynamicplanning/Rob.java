package dynamicplanning;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: suruomo
 * @date: 2020/9/23 10:12
 * @description:  337 打家劫舍3
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。
 * 这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。
 * 一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 */
public class Rob {
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
     * 用 f(o) 表示选择 o节点的情况下，o 节点的子树上被选择的节点的最大权值和；
     * 用 g(o) 表示不选择 o 节点的情况下，o 节点的子树上被选择的节点的最大权值和；
     */
    Map<TreeNode, Integer> f = new HashMap<TreeNode, Integer>();
    Map<TreeNode, Integer> g = new HashMap<TreeNode, Integer>();

    public int rob(TreeNode root) {
        dfs(root);
        return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }

    /**
     * 深度优先遍历
     * @param node
     */
    public void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        dfs(node.right);
        //情况1：当 o 被选中时，o 的左右孩子都不能被选中，
        //故o被选中情况下子树上被选中点的最大权值和为l和r不被选中的最大权值和相加，即f(o) = g(l) + g(r)。
        f.put(node, node.val + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0));
        //情况2：当 o 不被选中时，o 的左右孩子可以被选中，也可以不被选中。
        // 对于 o 的某个具体的孩子 x，它对 o 的贡献是 x 被选中和不被选中情况下权值和的较大值。
        // 故g(o)=max{f(l),g(l)}+max{f(r),g(r)}。
        g.put(node, Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }

}
