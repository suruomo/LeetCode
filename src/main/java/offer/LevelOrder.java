package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: suruomo
 * @date: 2020/12/7 10:37
 * @description:
 * 剑指 Offer 32 - I. 从上到下打印二叉树
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II
 */
public class LevelOrder {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode  right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 1.按层打印二叉树
     * @param root
     * @return
     */
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

    /**
     * 2.按层打印二叉树，每一层打印到一行
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root){
        if (root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> lists=new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            // 临时存储一行数据
            List<Integer> list=new ArrayList<>();
            // 当前行数据为当前队列中数据
            int n=queue.size();
            for (int i = 0; i <n; i++) {
                TreeNode node=queue.poll();
                list.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            lists.add(list);
        }
        return lists;
    }
}
