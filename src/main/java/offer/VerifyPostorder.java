package offer;

/**
 * @author: suruomo
 * @date: 2021/1/20 12:56
 * @description: 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    /**
     *  遍历后序遍历的 [i, j]区间元素，寻找 第一个大于根节点 的节点，索引记为 m。
     *  此时，可划分出左子树区间 [i,m-1]、右子树区间 [m, j - 1]、根节点索引 j
     * @param postorder
     * @param i
     * @param j
     * @return
     */
    boolean recur(int[] postorder, int i, int j) {
        if(i >= j) {
            return true;
        }
        int p = i;
        while(postorder[p] < postorder[j]) {
            p++;
        }
        // 左右子树区间标记
        int m = p;
        while(postorder[p] > postorder[j]) {
            p++;
        }
        return p == j && recur(postorder, i, m - 1) && recur(postorder, m, j - 1);
    }
}
