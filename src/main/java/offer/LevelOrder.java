package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: suruomo
 * @date: 2020/12/7 10:37
 * @description: 剑指 Offer 32 - I. 从上到下打印二叉树
 */
public class LevelOrder {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode  right;
        TreeNode(int x) { val = x; }
    }
    public int[] levelOrder(TreeNode root) {
        if (root==null){
            return new int[0];
        }
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<Integer> list=new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            list.add(node.val);
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
        }
        int[] res=new int[list.size()];
        int n=res.length;
        for (int i = 0; i < n; i++) {
            res[i]=list.get(i);
        }
        return res;
    }
}
