package tree;

/**
 * @Author: suruomo
 * @Date: 2020/8/24 16:15
 * @Description: 543 二叉树的直径
 *
 */
public class DiameterOfBinaryTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode  right;
        TreeNode(int x){
            val=x;
        }
    }
    int maxLength=0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxLength;
    }

    private int depth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int Left = depth(root.left);
        int Right = depth(root.right);
        maxLength=Math.max(Left+Right,maxLength);//将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        return Math.max(Left,Right)+1;//返回节点深度
    }
}
