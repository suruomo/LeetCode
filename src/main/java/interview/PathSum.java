package interview;

import java.util.ArrayList;

/**
 * @author: suruomo
 * @date: 2021/4/6 11:49
 * @description: 给定一个二叉树和一个值sum，请找出所有的根节点到叶子节点的节点值之和等于sum 的路径，
 */
public class PathSum {
    public class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode right=null;
    }
    /**
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> path=new ArrayList<>();
        backtrace(root,sum,res,path,0);
        return res;
    }

    private void backtrace(TreeNode root, int sum, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path, int result) {
        if (root==null){
            return;
        }
        result+= root.val;
        path.add(root.val);
        if (result==sum&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(path));
        }
        if (root.left!=null){
            backtrace(root.left, sum, res, path, result);
        }
        if (root.right!=null){
            backtrace(root.right, sum, res, path, result);
        }
        result-= root.val;
        path.remove(path.size()-1);
    }
}
