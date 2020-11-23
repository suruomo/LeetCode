package greedyalgorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: suruomo
 * @date: 2020/11/23 15:38
 * @description:  452. 用最少数量的箭引爆气球
 */
public class FindMinArrorShots {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        // 按照右侧位置从小到大排序
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        // 表示当前箭的射出位置
        int pos = points[0][1];
        // 表示射出的箭数
        int ans = 1;
        for (int[] balloon: points) {
            // 当前气球的左边界大于当前箭的右边界，则射箭加一，重置当前射箭
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }
}
