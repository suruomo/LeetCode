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
     * 递归
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

    /**
     * 查找最小节点：即最左子节点
     * 递归
     * @param root
     * @return
     */
    public BinaryNode findMin(BinaryNode root){
        if(root==null){
            return null;
        }
        else  if(root.getLeft()==null){
            return root;
        }
        return findMin(root.getLeft());
    }

    /**
     * 查找最大节点：即最右子节点
     * 非递归
     * @param root
     * @return
     */
    public BinaryNode findMax(BinaryNode root){
        if(root!=null){
            while(root.getRight()!=null){
                root=root.getRight();
            }
        }
        return root;
    }



}
