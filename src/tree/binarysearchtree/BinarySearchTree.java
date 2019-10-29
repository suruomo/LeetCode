package tree.binarysearchtree;

/**
 * @author 苏若墨
 */
public class BinarySearchTree{
    private BinaryNode root;

    public BinarySearchTree(BinaryNode root) {
        this.root = root;
    }

    /**
     * 判断二叉树中是否包含某节点
     * @param x
     * @param root
     * @return
     */

    public boolean contains(int x,BinaryNode root){
        if(root==null){
            return false;
        }
       int compareResult=root.compareTo(x);
        //根节点小于目标值，去右子树找
        if(compareResult<0){
            return contains(x,root.getRight());
        }
        //根节点大于目标值，去左子树找
        else if(compareResult>0){
            return contains(x,root.getLeft());
        }
        return true;
    }



}
