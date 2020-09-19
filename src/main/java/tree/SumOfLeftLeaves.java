package tree;

/**
 * @author: suruomo
 * @date: 2020/9/19 21:19
 * @description: 404 左叶子结点之和
 */
public class SumOfLeftLeaves {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val=x;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return root!=null?dfs(root):0;
    }

    private int dfs(TreeNode root) {
        int ans=0;
        if (root.left!=null){
            ans+=isLeafNode(root.left)? root.left.val:dfs(root.left);
        }
        if(root.right!=null&&!isLeafNode(root.right)){
            ans+=dfs(root.right);
        }
        return ans;
    }

    private boolean isLeafNode(TreeNode root) {
        return root.left==null&&root.right==null;
    }
}
