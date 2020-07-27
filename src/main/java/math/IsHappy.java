package math;

import java.util.HashSet;
import java.util.Set;

/**
 * @author suruomo
 * @date 2020/7/27 16:29
 * @description: 202 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 True ；不是，则返回 False 。
 */
public class IsHappy {
    public static void main(String[] args) {
        int n=19;
        System.out.println(isHappy(n));
    }

    private static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        //一定会陷入循环，用set来判断
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;

    }

    /**
     * 计算下一次数字
     * @param n
     * @return
     */
    private static int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }
}
