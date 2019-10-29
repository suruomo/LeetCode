package tree.traversing;

import java.util.Stack;

/**
 * @author 苏若墨
 */
public class BinaryTree {
    /**
     * 先序遍历递归版
     * @param root
     */
    public void preOrderRecursive(BinaryTreeNode root){
        if(root!=null){
            System.out.print(root.getData()+"\t");
            preOrderRecursive(root.getLeft());
            preOrderRecursive(root.getRight());
        }
    }

    /**
     * 先序遍历非递归版
     * @param root
     */
    public void preOrderNonRecursive(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack=new Stack<>();
        while(true){
            while(root!=null){
                System.out.print(root.getData()+"\t");
                stack.push(root);
                root=root.getLeft();
            }
            if(stack.isEmpty()){
                break;
            }
            root=stack.pop();
            root=root.getRight();
        }
    }

    /**
     * 中序遍历递归版
     * @param root
     */
    public void inOrderRecursive(BinaryTreeNode root){
        if(root!=null){
            inOrderRecursive(root.getLeft());
            System.out.print(root.getData()+"\t");
            inOrderRecursive(root.getRight());
        }
    }

    /**
     * 中序遍历非递归版
     * @param root
     */
    public void inOrderNonRecursive(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack=new Stack<>();
        while(true){
            while(root!=null){
                stack.push(root);
                root=root.getLeft();
            }
            if(stack.isEmpty()) {
                break;
            }
            root=stack.pop();
            System.out.print(root.getData()+"\t");
            root=root.getRight();
        }
    }

    /**
     * 后序遍历递归版
     * @param root
     */
    public void postOrderRecursive(BinaryTreeNode root){
        if(root!=null){
            postOrderRecursive(root.getLeft());
            postOrderRecursive(root.getRight());
            System.out.print(root.getData()+"\t");
        }
    }

    public void postOrderNonRecursive(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack=new Stack<>();
        //cur:当前访问节点，pre:上次访问节点
        BinaryTreeNode cur,pre;
        cur=root;
        pre=null;
        //先将cur移动到左子树最下边
        while(cur!=null){
            stack.push(cur);
            cur=cur.getLeft();
        }
        while (!stack.isEmpty()){
            cur=stack.pop();
            //一个根节点被访问的前提是：无右子树或右子树已被访问过
            if(cur.getRight()==null||cur.getRight()==pre){
                System.out.print(cur.getData()+"\t");
                pre=cur;
            }
            //否则左子树刚刚访问过，此时判断条件可以不写
            else if(cur.getLeft()==pre){
                stack.push(cur);
                //进入右子树
                cur=cur.getRight();
                while (cur!=null){
                    stack.push(cur);
                    cur=cur.getLeft();
                }
            }
        }
    }
}
