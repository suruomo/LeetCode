package interview;

import javax.lang.model.type.ArrayType;
import java.util.Arrays;

/**
 * @author: suruomo
 * @date: 2021/3/26 11:54
 * @description: 两数之和
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 */
public class TwoSum {
    /**
     *
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == target - numbers[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("no");
    }
}
