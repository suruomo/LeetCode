package interview;

/**
 * @author: suruomo
 * @date: 2021/3/29 17:21
 * @description:
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 */
public class AddBigNumber {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        // write code here
        char[] char1 = s.toCharArray();
        char[] char2 = t.toCharArray();
        int i = char1.length-1;
        int j = char2.length-1;
        //carry表进位
        int carry = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || carry != 0) {
            int a = 0;
            int b = 0;
            if(i >= 0) {
                a = char1[i] - '0';
                i--;
            }
            if (j >= 0) {
                b = char2[j] - '0';
                j--;
            }
            int sum = a + b + carry;
            int rem = sum % 10;
            carry = sum / 10;
            ans.append(rem);
        }
        StringBuffer res = ans.reverse();
        return new String(res);
    }
}
