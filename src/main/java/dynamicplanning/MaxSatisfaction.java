package dynamicplanning;

import java.util.Arrays;

/**
 * @author suruomo
 * @date 2020/7/3 15:20
 * @description: 1402
 * 一个厨师收集了他 n 道菜的满意程度 satisfaction ，这个厨师做出每道菜的时间都是 1 单位时间。
 *
 * 一道菜的 「喜爱时间」系数定义为烹饪这道菜以及之前每道菜所花费的时间乘以这道菜的满意程度，也就是 time[i]*satisfaction[i] 。
 *
 * 请你返回做完所有菜 「喜爱时间」总和的最大值为多少。
 *
 * 你可以按 任意 顺序安排做菜的顺序，你也可以选择放弃做某些菜来获得更大的总和。
 */
public class MaxSatisfaction {
    public static void main(String[] args) {
        int[] satisfaction={-1,-8,0,5,-9};
        System.out.println(maxSatisfaction(satisfaction));
    }

    /**
     * 贪心
     * 升序排序：满意程度最大的在最后面获得的喜爱时间最优
     * @param satisfaction
     * @return
     */
    private static int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int sum = 0;
        int ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            //若当前满意程度之和小于0，则后面的菜可放弃，当前结果最优
            //推论：若选择第二个菜，要求s2+2*s1（选择）>s1(不选）,则s2+s1>0
            //若选择第三个菜，要求s3+2*s2+3*s1（选择）>2*s2+3*s1(不选）,则s3+s2+s1>0
            if (sum + satisfaction[i] > 0) {
                sum += satisfaction[i];
                //重复加sum,相当于对先选的菜做乘法
                ans += sum;
            } else {
                break;
            }
        }
        return ans;
    }
}
