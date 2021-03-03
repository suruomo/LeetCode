package tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: suruomo
 * @date: 2021/3/3 10:50
 * @description: 230. 二叉搜索树中第K小的元素
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 */
public class KthSmallest {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 1.遍历整棵树，构造升序数组
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> arrayList=inorder(root,new ArrayList<>());
        return arrayList.get(k-1);
    }

    /**
     * 中序遍历为升序数组,遍历全部
     * @param root
     * @param arr
     * @return
     */
    private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root==null){
            return arr;
        }
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
        return arr;
    }

    /**
     * 2.遍历到结果处结束
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest1(TreeNode root, int k) {
        Stack<TreeNode> stack=new Stack<>();
        while (true){
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            root=stack.pop();
            if (--k==0) {
                return root.val;
            }
            root=root.right;
        }
    }
}
