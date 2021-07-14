package interview;

/**
 * @author: suruomo
 * @date: 2021/4/16 15:09
 * @description: 判断是否对称
 */
public class IsSymmetric {
    public class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode right=null;
    }
    /**
     *
     * @param root TreeNode类
     * @return bool布尔型
     */
    public boolean isSymmetric (TreeNode root) {
        return root==null?true:recur(root.left,root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if (left==null&&right==null){
            return true;
        }
        if (left==null||right==null||left.val!=right.val){
            return false;
        }
        return recur(left.left,right.right)&&recur(left.right,right.left);
    }
}
