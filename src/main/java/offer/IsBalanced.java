package offer;



/**
 * @author suruomo
 * @date 2020/7/18 16:13
 * @description:  剑指offer 55：输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class IsBalanced {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode  right;
    }
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }
    private static int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = recur(root.left);
        //左子树返回-1，表示不平衡
        if(left == -1) {
            return -1;
        }
        //右子树返回-1，表示不平衡
        int right = recur(root.right);
        if(right == -1) {
            return -1;
        }
        //当节点root 左 / 右子树的深度差>2 ：则返回−1 ，代表 此子树不是平衡树
        //否则返回当前子树的深度
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
