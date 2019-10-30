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
        System.out.println("初始树中序遍历：");
        binarySearchTree.inOrder(node1);
        System.out.println("查找1是否存在：");
        System.out.println(binarySearchTree.contains(1,node1));
        System.out.println("最小节点值："+binarySearchTree.findMin(node1).getData());
        System.out.println("最大节点值："+binarySearchTree.findMax(node1).getData());
        System.out.println("插入结点值7...");
        node1=binarySearchTree.insert(7,node1);
        binarySearchTree.inOrder(node1);
        System.out.println(binarySearchTree.contains(7,node1));
        System.out.println("删除结点值7...");
        node1=binarySearchTree.remove(7,node1);
        binarySearchTree.inOrder(node1);
        System.out.println(binarySearchTree.contains(7,node1));
        System.out.println("BST的最大深度是："+binarySearchTree.maxDepth(node1));
    }
}
