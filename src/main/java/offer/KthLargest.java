package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2020/12/17 9:49
 * @description: 剑指 Offer 54. 二叉搜索树的第k大节点
 */
public class KthLargest {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode  right;
        TreeNode(int x){
            val=x;
        }
    }

    /**
     * res存储结果
     * n维护当前遍历到第i大结点
     */
    private int res,n;

    /**
     * 方法1：全部遍历，存进数组，效率低
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        List<Integer> list=new ArrayList<>();
        inOrder(root,list);
        int[] ans=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i]=list.get(i);
        }
        return ans[ans.length-k];
    }

    /**
     * 中序遍历
     * @param root
     * @param list
     */
    private void inOrder(TreeNode root, List<Integer> list) {
        if (root==null){
            return;
        }
        if (root.left!=null){
            inOrder(root.left,list);
        }
        list.add(root.val);
        if (root.right!=null){
            inOrder(root.right,list);
        }
    }

    /**
     * 先遍历右子树，若找到就返回
     * @param root
     * @param k
     * @return
     */
    public int kthLargest1(TreeNode root,int k){
        n=k;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if(root==null||n==0){
            return;
        }
        dfs(root.right);
        if (--n==0){
            res= root.val;
            return;
        }
        dfs(root.left);
    }

}
