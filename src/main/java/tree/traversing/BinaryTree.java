package tree.traversing;

import java.util.*;

/**
 * @author 苏若墨
 */
public class BinaryTree {
    /**
     * 先序遍历递归版
     *
     * @param root
     */
    public void preOrderRecursive(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.getData() + "\t");
            preOrderRecursive(root.getLeft());
            preOrderRecursive(root.getRight());
        }
    }

    /**
     * 先序遍历非递归版
     *
     * @param root
     */
    public void preOrderNonRecursive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                System.out.print(root.getData() + "\t");
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            root = root.getRight();
        }
    }

    /**
     * 中序遍历递归版
     *
     * @param root
     */
    public void inOrderRecursive(BinaryTreeNode root) {
        if (root != null) {
            inOrderRecursive(root.getLeft());
            System.out.print(root.getData() + "\t");
            inOrderRecursive(root.getRight());
        }
    }

    /**
     * 中序遍历非递归版
     *
     * @param root
     */
    public void inOrderNonRecursive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            }
            root = stack.pop();
            System.out.print(root.getData() + "\t");
            root = root.getRight();
        }
    }

    /**
     * 后序遍历递归版
     *
     * @param root
     */
    public void postOrderRecursive(BinaryTreeNode root) {
        if (root != null) {
            postOrderRecursive(root.getLeft());
            postOrderRecursive(root.getRight());
            System.out.print(root.getData() + "\t");
        }
    }

    /**
     * 后序遍历非递归版
     *
     * @param root
     */
    public void postOrderNonRecursive(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        //cur:当前访问节点，pre:上次访问节点
        BinaryTreeNode cur, pre;
        cur = root;
        pre = null;
        //先将cur移动到左子树最下边
        while (cur != null) {
            stack.push(cur);
            cur = cur.getLeft();
        }
        while (!stack.isEmpty()) {
            cur = stack.pop();
            //一个根节点被访问的前提是：无右子树或右子树已被访问过
            if (cur.getRight() == null || cur.getRight() == pre) {
                System.out.print(cur.getData() + "\t");
                pre = cur;
            }
            //否则左子树刚刚访问过，此时判断条件可以不写
            else if (cur.getLeft() == pre) {
                stack.push(cur);
                //进入右子树
                cur = cur.getRight();
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.getLeft();
                }
            }
        }
    }

    /**
     * 层次遍历
     *
     * @param root
     */
    public List hierarchicalTraversal(BinaryTreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            list.add(node.getData());
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.offer(node.getRight());
            }
        }
        return list;
    }

    /**
     * 层次遍历：按层打印
     */
    public void printByHierarchically(BinaryTreeNode root) {
        if (root == null) {
            System.out.println("二叉树为空");
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        //last:指向当前层最右结点
        //nlast:指向下一层最右结点
        BinaryTreeNode last = root;
        BinaryTreeNode nlast = root;
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            //打印当前结点
            System.out.print(node.getData() + "--");
            //若左孩子不为空入队
            if (node.getLeft() != null) {
                queue.offer(node.getLeft());
                nlast = node.getLeft();
            }
            //若右孩子不为空入队
            if (node.getRight() != null) {
                queue.offer(node.getRight());
                nlast = node.getRight();
            }
            //若当前弹出结点为该层最右结点，让last指向下一层最右结点并换行
            if (last == node) {
                last = nlast;
                System.out.print("\n");
            }
        }
    }

    /**
     * 判断二叉树是否对称
     */
    public boolean isSymmetric(BinaryTreeNode root) {
        return isMirror(root, root);
    }

    /**
     * 判断对称
     *
     * @param t1
     * @param t2
     * @return
     */
    public boolean isMirror(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return (t1.getData() == t2.getData())
                && isMirror(t1.getRight(), t2.getLeft())
                && isMirror(t1.getLeft(), t2.getRight());
    }

}
