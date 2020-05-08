package greedyalgorithm;

import java.util.Arrays;

/**
 * 问题881：第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 *
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 *
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 1 <= people.length <= 50000
 1 <= people[i] <= limit <= 30000
 思路：排序后双指针，
 如果最重的人可以与最轻的人共用一艘船，那么就这样安排。否则，最重的人无法与任何人配对，那么他们将自己独自乘一艘船。
 * @author 苏若墨
 */
public class NumRescueBoats {
    public static void main(String[] args) {
        int[] people={1,2};
        int limit=3;
        System.out.println(numRescueBoats(people,limit));
    }

    private static int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        int ans = 0;
        while (i <= j) {
            ans++;
            if (people[i] + people[j] <= limit) {
                i++;
            }
            j--;
        }
        return ans;
    }
}

