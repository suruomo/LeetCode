package interview;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2021/4/6 11:16
 * @description:
 * 给定一个仅包含数字0−9 的二叉树，每一条从根节点到叶子节点的路径都可以用一个数字表示。
 * 找出根节点到叶子节点的所有路径表示的数字之和
 */
public class SumNumbers {
    public class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode right=null;
    }
    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int sumNumbers (TreeNode root) {
        if (root==null){
            return 0;
        }
       List<String> res=new ArrayList<>();
       dfs(root,res,new StringBuilder());
       int sum=0;
        for (int i = 0; i < res.size(); i++) {
            sum+=Integer.valueOf(res.get(i));
        }
        return sum;
    }

    private void dfs(TreeNode root, List<String> res, StringBuilder stringBuilder) {
        if (root==null){
            return;
        }
        stringBuilder.append(root.val);
        if (root.left==null&&root.right==null){
            res.add(stringBuilder.toString());
        }
        if (root.left!=null){
            dfs(root.left,res,stringBuilder);
        }
        if (root.right!=null){
            dfs(root.right,res,stringBuilder);
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
    }
}
