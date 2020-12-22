package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: suruomo
 * @date: 2020/12/22 11:35
 * @description: 103. 二叉树的锯齿形层序遍历
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（
 * 即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 思路：
 * 使用双端队列
 * 当从左向右时加入队尾
 * 当从右向左时加入队头
 */
public class ZigZagLevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new LinkedList<>();
        if (root==null){
            return ans;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        // 判断左右标志
        // 从左向右为true,从右向左为false
        boolean isLeftOrder=true;
        while (!queue.isEmpty()){
            Deque<Integer> deque=new LinkedList<>();
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node=queue.poll();
                if (isLeftOrder){
                    deque.addLast(node.val);
                }else {
                    deque.addFirst(node.val);
                }
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            ans.add(new LinkedList<>(deque));
            isLeftOrder=!isLeftOrder;
        }
        return ans;
    }
}
