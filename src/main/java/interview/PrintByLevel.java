package interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: suruomo
 * @date: 2021/6/7 11:05
 * @description: 二叉树按层打印，从左向右
 */
public class PrintByLevel {
    public class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode right=null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 层次遍历
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        if (pRoot==null){
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()){
            int size=queue.size();
            ArrayList<Integer> list=new ArrayList<>();
            for (int i = 0; i < size; i++) {
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
