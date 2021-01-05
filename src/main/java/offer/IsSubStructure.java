package offer;

/**
 * @author: suruomo
 * @date: 2021/1/5 11:22
 * @description: 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值
 */
public class IsSubStructure {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode  right;
        TreeNode(int x){
            val=x;
        }
    }

    /**
     * 遍历A的每个结点，判断B是否是A的子结构
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 返回true三种情况 A.B都不为空
        // 1. A为根结点包含B
        // 2. B在A的左子树中
        // 3. B在A的右子树中
        // 否则如果A.B任一为null,返回false
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    /**
     * 判断结点A,B是否相等
     * @param A
     * @param B
     * @return
     */
    private boolean recur(TreeNode A, TreeNode B) {
        // 终止条件1：B已经遍历完毕
        if (B==null){
            return true;
        }
        // 终止条件2：A已经遍历到叶子节点或者当前值不匹配
        if (A==null||A.val!=B.val){
            return false;
        }
        // 递归过程，判断左右结点是否相等
        return recur(A.left,B.left)&&recur(A.right,B.right);
    }
}
