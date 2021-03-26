package interview;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author: suruomo
 * @date: 2021/3/26 10:52
 * @description: 二叉树的层次遍历
 */
public class CengciTraverse {
    public class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode right=null;
    }
    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        Queue<TreeNode> queue=new ArrayDeque<>();
        if (root==null){
            return lists;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            ArrayList<Integer> list=new ArrayList<>();
            int len=queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node=queue.poll();
                list.add(node.val);
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
