package offer;

import java.util.*;

/**
 * @Author: suruomo
 * @Date: 2021/6/28 10:54
 * @Description: 二叉搜索树与双向链表
 * 不能新建节点，只能改变节点指向
 */
public class BSTLinkedList {
    /**
     * 节点类
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null){
            return null;
        }
        List<TreeNode> list=new ArrayList<>();
        preOrder(pRootOfTree,list);
        return covert(list);
    }

    private TreeNode covert(List<TreeNode> list) {
        TreeNode head=list.get(0);
        TreeNode cur=head;
        for (int i = 1; i < list.size(); i++) {
            TreeNode node=list.get(i);
            node.left=cur;
            cur.right=node;
            cur=node;
        }
        return head;
    }

    /**
     * 中序遍历，结果存入列表
     * @param pRootOfTree
     * @param list
     */
    private void preOrder(TreeNode pRootOfTree, List<TreeNode> list) {
        if (pRootOfTree!=null){
            preOrder(pRootOfTree.left,list);
            list.add(pRootOfTree);
            preOrder(pRootOfTree.right,list);
        }
    }
}