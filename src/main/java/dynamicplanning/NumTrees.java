package dynamicplanning;

/**
 * 问题96：给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 思路：遍历每个数字 i，将该数字作为树根，1 ... (i-1) 序列将成为左子树，(i+1) ... n 序列将成为右子树。
 * 于是，我们可以递归地从子序列构建子树。
 * @author 苏若墨
 */
public class NumTrees {
    public static void main(String[] args) {
        int n=7;
        System.out.println(sumTrees(n));
    }

    /**
     * G(n): 长度为n的序列的不同二叉搜索树个数。
     * F(i,n): 以i为根的不同二叉搜索树个数(1 \leq i \leq n1≤i≤n)。
     *
     *举例而言：
     * F(3,7)，以 3 为根的不同二叉搜索树个数。
     * 为了以 3 为根从序列 [1, 2, 3, 4, 5, 6, 7] 构建二叉搜索树，我们需要从左子序列 [1, 2] 构建左子树，从右子序列 [4, 5, 6, 7] 构建右子树，
     * 然后将它们组合(即笛卡尔积)。
     * 我们可以将 [1,2] 构建不同左子树的数量表示为G(2), 从 [4, 5, 6, 7]` 构建不同右子树的数量表示为 G(4)。
     * 这是由于 G(n) 和序列的内容无关，只和序列的长度有关。于是，F(3,7)=G(2)⋅G(4)。
     * 所以：
     * F(i,n)=G(i−1)⋅G(n−i)
     * @param n
     * @return
     */
    private static int sumTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
