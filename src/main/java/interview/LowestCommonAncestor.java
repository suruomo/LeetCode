package interview;


/**
 * @author: suruomo
 * @date: 2021/3/30 12:55
 * @description: 给定一棵二叉树以及这棵树上的两个节点 o1 和 o2，请找到 o1 和 o2 的最近公共祖先节点。
 */
public class LowestCommonAncestor {
    public class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode right=null;
    }
    private TreeNode ans;
    /**
     *
     * @param root TreeNode类
     * @param o1 int整型
     * @param o2 int整型
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
      dfs(root,o1,o2);
      return this.ans.val;
    }

    private boolean dfs(TreeNode root, int o1, int o2) {
        if (root==null){
            return false;
        }
        boolean l=dfs(root.left,o1,o2);
        boolean r=dfs(root.right,o1,o2);
        if ((l&&r)||((root.val==o1||root.val==o2)&&(l||r))){
            ans=root;
        }
        return l||r||(root.val==o1||root.val==o2);
    }
}
