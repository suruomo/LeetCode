package tree.binarysearchtree;

/**
 * @author 苏若墨
 */
public class BinaryNode implements Comparable{
    private int data;
    private BinaryNode right;
    private BinaryNode left;

    public BinaryNode() {
    }

    public BinaryNode(int data, BinaryNode right, BinaryNode left) {
        this.data = data;
        this.right = right;
        this.left = left;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    @Override
    public int compareTo(Object o) {
        if(this.data>(Integer) o){
            return  1;
        }
        else if(this.data<(Integer) o){
            return -1;
        }
        return 0;
    }
}
