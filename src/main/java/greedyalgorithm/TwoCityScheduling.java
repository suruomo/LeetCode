package greedyalgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 问题：公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 * 思路：对于这2N个人，按照去A地和去B地的费用之差从小到大排序
 * 选出前N个去A地，后N个去B地
 *
 * @author 苏若墨
 */
public class TwoCityScheduling {
    public int twoCitySchedCost(int [][] costs){
        int n=costs.length/2;
        int total = 0;
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });
        // To optimize the company expenses,
        // send the first n persons to the city A
        // and the others to the city B
        for (int i = 0; i < n; ++i) {
            total += costs[i][0] + costs[i + n][1];
        }
        return total;
    }
}
