package array;

import java.util.Scanner;

/**
 * @author 苏若墨
 * 问题：
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 判断字符串是不是回文字符串
 * 思路：针对这个问题，我们可以使用头尾双指针，
 * <p>
 * 如果两个指针的元素不相同，则直接返回false,
 * 如果两个指针的元素相同，我们同时更新头尾指针，循环。 直到头尾指针相遇。
 * 时间复杂度为O(n).
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println("请输入字符串：");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (judge(s)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static boolean judge(String s) {
        char[] c = s.toCharArray();
        int l = 0;
        int r = c.length - 1;
        while (l < r) {
            if (c[l] == c[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
