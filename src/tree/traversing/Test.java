package tree.traversing;

/**
 * @author 苏若墨
 */
public class Test {
    public static void main(String[] args) {
        BinaryTreeNode node10=new BinaryTreeNode(10,null,null);
        BinaryTreeNode node8=new BinaryTreeNode(8,null,null);
        BinaryTreeNode node9=new BinaryTreeNode(9,null,node10);
        BinaryTreeNode node4=new BinaryTreeNode(4,null,null);
        BinaryTreeNode node5=new BinaryTreeNode(5,node8,node9);
        BinaryTreeNode node6=new BinaryTreeNode(6,null,null);
        BinaryTreeNode node7=new BinaryTreeNode(7,null,null);
        BinaryTreeNode node2=new BinaryTreeNode(2,node4,node5);
        BinaryTreeNode node3=new BinaryTreeNode(3,node6,node7);
        BinaryTreeNode node1=new BinaryTreeNode(1,node2,node3);
        BinaryTree binaryTree=new BinaryTree();
        System.out.println("先序遍历递归版遍历");
        binaryTree.preOrderRecursive(node1);
        System.out.println();
        System.out.println("先序遍历非递归版");
        binaryTree.preOrderNonRecursive(node1);
        System.out.println();
        System.out.println("中序遍历递归版遍历");
        binaryTree.inOrderRecursive(node1);
        System.out.println();
        System.out.println("中序遍历非递归版");
        binaryTree.inOrderNonRecursive(node1);
        System.out.println();
        System.out.println("后序遍历递归版遍历");
        binaryTree.postOrderRecursive(node1);
        System.out.println();
        System.out.println("后序遍历非递归版");
        binaryTree.postOrderNonRecursive(node1);
        System.out.println();
        System.out.println("层次遍历");
        binaryTree.hierarchicalTraversal(node1);
        System.out.println("二叉树是否对称："+binaryTree.isSymmetric(node1));

    }
}
