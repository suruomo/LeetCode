package interview;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: suruomo
 * @date: 2021/3/30 10:03
 * @description: 给定一个二叉树，返回该二叉树的之字形层序遍历，
 * （第一层从左向右，下一层从右向左，一直这样交替）
 */
public class ZigZagLevelOrder {
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        // write code here
        // 结果集
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        // 奇偶标志，false是奇数层，true是偶数层
        boolean flag=false;
        // 队列
        Deque<TreeNode> deque=new LinkedList<>();
        if(root!=null){
            deque.add(root);
        }
        while (!deque.isEmpty()){
            int len=deque.size();
            Deque<Integer> deque1=new LinkedList<>();
            for (int i = 0; i < len; i++) {
                TreeNode node=deque.poll();
                // 偶数层添加头部，奇数层添加尾部
                if (flag){
                    deque1.addFirst(node.val);
                }else {
                    deque1.addLast(node.val);
                }
                if (node.left!=null){
                    deque.add(node.left);
                }
                if (node.right!=null){
                    deque.add(node.right);
                }
            }
            lists.add(new ArrayList<>(deque1));
            flag=!flag;
        }
        return lists;
    }
}
