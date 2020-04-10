package tree.traversing;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    BinaryTreeNode node10=new BinaryTreeNode(null,null);
    BinaryTreeNode node5=new BinaryTreeNode(5,node8,node9);
    BinaryTreeNode node6=new BinaryTreeNode(6,10,null,null);
    BinaryTreeNode node8=new BinaryTreeNode(8,null,null);
    BinaryTreeNode node9=new BinaryTreeNode(9,null,node10);
    BinaryTreeNode node4=new BinaryTreeNode(4,null,null);
    BinaryTreeNode node7=new BinaryTreeNode(7,null,null);
    BinaryTreeNode node2=new BinaryTreeNode(2,node4,node5);
    BinaryTreeNode node3=new BinaryTreeNode(3,node6,node7);
    BinaryTreeNode node1=new BinaryTreeNode(1,node2,node3);
    BinaryTree binaryTree=new BinaryTree();
    @Test
    public void returnHierarchically() {
        System.out.println(binaryTree.returnHierarchically(node1));
    }
}