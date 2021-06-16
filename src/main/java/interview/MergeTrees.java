package interview;

/**
 * @author: suruomo
 * @date: 2021/6/16 13:41
 * @description: 合并两棵树
 * 相同位置结点值相加，否则由一个树的结点代替
 */
public class MergeTrees {
    public class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode right=null;
    }
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        if(t1 == null) {
            return t2;
        }
        if(t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
