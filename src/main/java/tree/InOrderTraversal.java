package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author suruomo
 * @date 2020/7/5 15:46
 * @description:94，返回一个二叉树的中序遍历
 */
public class InOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> inOrderTraversal(TreeNode root){
          List<Integer> list=new ArrayList<>();
          Stack<TreeNode> stack=new Stack<>();
          while (!stack.isEmpty()|| root!=null){
              while (root != null) {
                  stack.push(root);
                  root = root.left;
              }
              root = stack.pop();
              list.add(root.val);
              root = root.right;
          }
          return list;
    }
}
