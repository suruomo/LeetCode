package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2020/12/22 11:57
 * @description: 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 */
public class FindContinuousSequence {
    /**
     * 枚举每个正整数为起点，判断以它为起点的序列和sum是否等于target 即可，
     * 由于题目要求序列长度至少大于 2，所以枚举的上界为target/2
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans=new ArrayList<>();
        int sum=0;
        int limit=target/2;
        for (int i = 1; i <=limit; i++) {
            for (int j = i;; j++) {
                sum+=j;
                if (sum>target){
                    sum=0;
                    break;
                }else if (sum==target){
                    // 添加连续数字
                    int[] res=new int[j-i+1];
                    for (int k = i; k <=j; k++) {
                        res[k-i]=k;
                    }
                    ans.add(res);
                    sum=0;
                    break;
                }
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
