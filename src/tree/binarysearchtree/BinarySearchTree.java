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

    /**
     * 插入某个值x
     * @param x 待插入值x
     * @param root  待插入树根节点
     * @return  返回新树根节点
     */
    public BinaryNode insert(int x,BinaryNode root){
        if(root==null){
            return new BinaryNode(x,null,null);
        }
        int compareResult=root.compareTo(x);
        if(compareResult<0){
           root.setRight(insert(x,root.getRight()));
    }
        else if(compareResult>0){
            root.setLeft(insert(x,root.getLeft()));
        }
        return root;
    }

    /**
     * 递归中序遍历
     * @param root
     */
    public void inOrder(BinaryNode root){
        if(root!=null){
            inOrder(root.getLeft());
            System.out.print(root.getData()+"\t");
            inOrder(root.getRight());
        }
    }

    public BinaryNode remove(int x,BinaryNode root){
        if(root==null){
            return null;
        }
        int compareResult=root.compareTo(x);
        //若待删除元素值大于当前节点，去右子树删除
        if(compareResult<0){
           root.setRight(remove(x,root.getRight()));
        }
        else{
            //若待删除元素值小于当前节点，去左子树删除
            if(compareResult>0){
                root.setLeft(remove(x,root.getLeft()));
            }
            //否则待删除元素就是当前结点
            //当该结点有两个孩子时，令当前结点值为其右子树最小结点值，然后删除其右子树自小结点
            else if(root.getLeft()!=null&&root.getRight()!=null){
                root.setData(findMin(root.getRight()).getData());
                root.setRight(remove(root.getData(),root.getRight()));
            }
            //当前结点只有左孩子或者只有右孩子
            else{
                root=(root.getLeft()!=null)?root.getLeft():root.getRight();
            }
        }
        return root;
    }

}
