package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: suruomo
 * @date: 2020/11/27 10:16
 * @description: 454. 四数相加 II
 * 给定四个包含整数的数组列表A , B , C , D ,计算有多少个元组 (i, j, k, l)，使得A[i] + B[j] + C[k] + D[l] = 0。
 * 所有的 A, B, C, D 具有相同的长度 N
 *
 */
public class FourSumCount {
    /**
     * 将四个数组分成两部分，A 和 B 为一组，C 和 D 为另外一组。
     * 遍历A和B，存入哈希表
     * 对于哈希映射中的每个键值对，每个键表示一种 A[i]+B[j]，对应的值为 A[i]+B[j] 出现的次数。
     * 遍历C和D,如果 −(C[k]+D[l]) 出现在哈希映射中，那么将 −(C[k]+D[l]) 对应的出现次数值累加进答案中。
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> countAB = new HashMap<Integer, Integer>();
        for (int u : A) {
            for (int v : B) {
                countAB.put(u + v, countAB.getOrDefault(u + v, 0) + 1);
            }
        }
        int ans = 0;
        for (int u : C) {
            for (int v : D) {
                if (countAB.containsKey(-u - v)) {
                    ans += countAB.get(-u - v);
                }
            }
        }
        return ans;
    }
}
