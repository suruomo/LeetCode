package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suruomo
 * @date 2020/8/10 15:04
 * @description: 696 给定一个字符串 s，计算具有相同数量0和1的非空(连续)子字符串的数量，
 * 并且这些子字符串中的所有0和所有1都是组合在一起的。
 * 重复出现的子串要计算它们出现的次数。
 *输入: "10101"
 * 输出: 4
 * 解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
 */
public class CountBinarySubStrings {
    public static void main(String[] args) {
        String s="10101";
        System.out.println("第一种未优化："+countBinarySubStrings(s));
        System.out.println("第二种优化："+countBinarySubStrings1(s));
    }

    /**
     * 对于某一个位置 i，其实我们只关心 i - 1位置的counts 值是多少，
     * 所以可以用一个 last 变量来维护当前位置的前一个位置，这样可以省去一个counts 数组的空间。
     *
     *优化空间复杂度为1
     * @param s
     * @return
     */
    private static int countBinarySubStrings1(String s) {
        int ptr = 0, n = s.length(), last = 0, ans = 0;
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            ans += Math.min(count, last);
            last = count;
        }
        return ans;
    }

    /**
     * 时间空间复杂度都是O(n)
     * @param s
     * @return
     */
    private static int countBinarySubStrings(String s) {
        List<Integer> counts = new ArrayList<Integer>();
        int ptr = 0, n = s.length();
        while (ptr < n) {
            char c = s.charAt(ptr);
            int count = 0;
            while (ptr < n && s.charAt(ptr) == c) {
                ++ptr;
                ++count;
            }
            counts.add(count);
        }
        int ans = 0;
        for (int i = 1; i < counts.size(); ++i) {
            ans += Math.min(counts.get(i), counts.get(i - 1));
        }
        return ans;
    }
}
