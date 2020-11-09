package array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: suruomo
 * @date: 2020/11/9 9:58
 * @description: 973. 最接近原点的 K 个点
 */
public class kClosest {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0]*o1[0]+o1[1]*o1[1])-(o2[0]*o2[0]+o2[1]*o2[1]);
            }
        });
        return Arrays.copyOfRange(points,0,K);
    }
}
