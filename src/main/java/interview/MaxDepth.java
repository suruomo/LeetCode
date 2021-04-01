package interview;

/**
 * @author: suruomo
 * @date: 2021/4/1 10:41
 * @description:
 */
public class MaxDepth {
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
    public int maxDepth (TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftDepth=maxDepth(root.left);
        int rightDepth=maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }
}
