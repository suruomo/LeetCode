package tree.binarysearchtree;

/**
 * @author 苏若墨
 */
public class Test {
    public static void main(String[] args) {
        BinaryNode node4=new BinaryNode(5,null,null);
        BinaryNode node5=new BinaryNode(3,null,null);
        BinaryNode node6=new BinaryNode(8,null,null);
        BinaryNode node7=new BinaryNode(10,null,null);
        BinaryNode node2=new BinaryNode(4,node4,node5);
        BinaryNode node3=new BinaryNode(9,node7,node6);
        BinaryNode node1=new BinaryNode(6,node3,node2);
        BinarySearchTree binarySearchTree=new BinarySearchTree(node1);
        System.out.println(binarySearchTree.contains(1,node1));
    }
}
