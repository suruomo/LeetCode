package interview;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @author: suruomo
 * @date: 2021/4/12 11:26
 * @description: 给定一棵二叉树，已经其中没有重复值的节点，请判断该二叉树是否为搜索二叉树和完全二叉树。
 */
public class JudgeIt {
    public class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode right=null;
    }
    /**
     *
     * @param root TreeNode类 the root
     * @return bool布尔型一维数组
     */
    public boolean[] judgeIt (TreeNode root) {
        return new boolean[]{isBST(root),isComplete(root)};
    }

    /**
     * 判断完全二叉树
     * @param root
     * @return
     */
    private boolean isComplete(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            if (node!=null){
                queue.offer(node.left);
                queue.offer(node.right);
            }else {
                while (!queue.isEmpty()){
                    TreeNode temp=queue.poll();
                    if (temp != null) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * 判断二叉搜索树
     * @param root
     * @return
     */
    private boolean isBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
