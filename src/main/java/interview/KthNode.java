package interview;

import java.util.Stack;

/**
 * @author: suruomo
 * @date: 2021/4/26 11:45
 * @description: 给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
 */
public class KthNode {
    public class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode right=null;
    }
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot==null||k<0){
            return null;
        }
        TreeNode root=pRoot;
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty()||root!=null){
            if (root!=null){
                stack.push(root);
                root=root.left;
            }else{
                root=stack.pop();
                if (--k==0){
                    return root;
                }
                root=root.right;
            }
        }
        return null;
    }
}
