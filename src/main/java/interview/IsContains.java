package interview;

/**
 * @author: suruomo
 * @date: 2021/6/16 13:28
 * @description: 判断t1树中是否有与t2树拓扑结构完全相同的子树
 */
public class IsContains {
    public class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode right=null;
    }

    /**
     * 1.递归
     * @param root1
     * @param root2
     * @return
     */
    public boolean isContains (TreeNode root1, TreeNode root2) {
        // write code here
        if(root1==null){
            return false;
        }
        return isContains(root1.left,root2) || isContains(root1.right,root2) || isSubTree(root1,root2);
    }

    public boolean isSubTree(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null || root1.val!=root2.val){
            return false;
        }
        return isSubTree(root1.left,root2.left) && isSubTree(root1.right,root2.right);
    }

    /**
     * 2.中序遍历，判断字符串序列
     * @param root1
     * @param root2
     * @return
     */
    public boolean isContains1 (TreeNode root1, TreeNode root2) {
        // write code here
        StringBuffer res1=new StringBuffer();
        StringBuffer res2=new StringBuffer();
        preOrder(root1,res1);
        preOrder(root2,res2);
        if(res1.toString().contains(res2.toString())){
            return true;
        }
        else{
            return false;
        }
    }
    public void preOrder(TreeNode root,StringBuffer res){
        if(root==null){
            return;
        }
        preOrder(root.left,res);
        res.append(root.val);
        preOrder(root.right,res);
    }
}
