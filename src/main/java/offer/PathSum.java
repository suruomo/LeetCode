package offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2021/1/26 13:55
 * @description: 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 */
public class PathSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res=new LinkedList<>();
        Deque<Integer> path=new LinkedList<>();
        backtrace(res,path,root,sum);
        return res;
    }

    /**
     * 先序+回溯
     * @param res 结果集
     * @param path 搜索路径
     * @param root 当前结点
     * @param sum 剩余和
     */
    private void backtrace(List<List<Integer>> res, Deque<Integer> path, TreeNode root, int sum) {
        if (root==null){
            return;
        }
        sum-= root.val;
        // 找到一条路径
        if (sum==0&&root.left==null&&root.right==null){
            path.addLast(root.val);
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        // 添加
        path.addLast(root.val);
        // 回溯
        if (root.left!=null){
            backtrace(res,path,root.left,sum);
        }
        if (root.right!=null){
            backtrace(res,path,root.right,sum);
        }
        // 删除
        path.removeLast();
    }
}
