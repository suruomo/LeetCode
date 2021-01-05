package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2021/1/5 13:17
 * @description: 113. 路径总和 II
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
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
        List<Integer> path=new LinkedList<>();
        dfs(res,new LinkedList<>(),root,sum);
        return res;
    }

    /**
     * 回溯
     * @param res
     * @param path
     * @param root
     * @param sum
     */
    private void dfs(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum) {
        if (root!=null){
            // 1.增加当前结点值
            sum-= root.val;
            path.add(root.val);
            // 判断添加条件
            if (root.left==null && root.right==null && sum==0){
                // 注意不是直接添加，path为引用型，必须拷贝添加
                res.add(new ArrayList<>(path));
                path.remove(path.size()-1);
                return;
            }
            // 2.搜索孩子结点
            dfs(res,path,root.left,sum);
            dfs(res,path,root.right,sum);
            // 3.删除当前添加
            path.remove(path.size()-1);
        }
    }

    /**
     * 深度优先遍历(递归),注意分支污染
     * @param res
     * @param path
     * @param root
     * @param sum
     */
    private void dfs1(List<List<Integer>> res, List<Integer> path, TreeNode root, int sum) {
        if (root!=null){
            //
            sum-= root.val;
            // 因为path是引用传递，为了防止递归的时候分支污染，我们要在每个路径
            // 中都要新建一个list
            List<Integer> list=new ArrayList<>(path);
            list.add(root.val);
            // 判断添加条件
            if (root.left==null && root.right==null && sum==0){
                // 注意不是直接添加，path为引用型，必须拷贝添加
                res.add(list);
                return;
            }
            dfs(res,list,root.left,sum);
            dfs(res,list,root.right,sum);
        }
    }
}
