package interview;

/**
 * @author: suruomo
 * @date: 2021/4/26 10:56
 * @description: 判断数字是否回文，不可借助额外空间
 */
public class IsPalindrome {
    /**
     * 将数字翻转后，与原数字比较
     * 反转数字的方法是将x不断对10取模，然后除以10。
     * @param x
     * @return
     */
    public boolean isPalindrome (int x) {
        if (x < 0) {
            return false;
        }
        int tmp = x, y = 0;
        while (tmp>0) {
            y = y * 10 + tmp % 10;
            tmp /= 10;
        }
        return x == y;
    }
}
