package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2020/10/28 9:51
 * @description:
 */
public class Merge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 将列表中的区间按照左端点升序排序
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        // 合并结果数组
        List<int[]> merged = new ArrayList<int[]>();
        // 遍历已排序数组
        for (int i = 0; i < intervals.length; ++i) {
            // 左端点值，右端点值
            int L = intervals[i][0], R = intervals[i][1];
            // 如果当前区间的左端点在数组 merged 中最后一个区间的右端点之后，那么它们不会重合
            // 我们可以直接将这个区间加入数组 merged 的末尾；
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                // 否则，它们重合，
                // 我们需要用当前区间的右端点更新数组 merged 中最后一个区间的右端点
                // 将其置为二者的较大值。
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
