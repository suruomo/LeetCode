package offer;


import java.util.*;

/**
 * @Author: suruomo
 * @Date: 2021/6/28 11:19
 * @Description: 找到搜索二叉树中两个错误的节点
 * 一棵二叉树原本是搜索二叉树，但是其中有两个节点调换了位置，
 * 使得这棵二叉树不再是搜索二叉树，请按升序输出这两个错误节点的值。(每个节点的值各不相同)
 */
public class FindError {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }
    public int[] findError (TreeNode root) {
        if (root==null){
            return new int[2];
        }
        int[] ans=new int[2];
        int index=1;
        Stack<TreeNode> stack=new Stack<>();
        TreeNode pre = null;
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if (pre==null){
                pre=root;
            }
            if (index==1&&root.val<pre.val){
               ans[index]= pre.val;
               index--;
            }
            if (index==0&&root.val<pre.val){
                ans[index]= root.val;
            }
            pre=root;
            root=root.right;
        }
        return ans;
    }
}
