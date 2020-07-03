package tree;


/**
 * @author suruomo
 * @date 2020/7/3 14:52
 * @description:108,将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 */
public class SortedArrayToBST {
    /**
     * 结点定义
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 取中间的数字作为根节点，递归的构造BST
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums,0,nums.length-1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if(left>right){
            return null;
        }
     //取中间的数字作为根节点
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,left,mid-1);
        root.right=helper(nums,mid+1,right);
        return root;
    }
}
