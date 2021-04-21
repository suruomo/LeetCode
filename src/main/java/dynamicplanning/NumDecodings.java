package dynamicplanning;

/**
 * @author: suruomo
 * @date: 2021/4/21 13:33
 * @description: 91. 解码方法
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 */
public class NumDecodings {
    public int numDecodings(String s) {
        int n = s.length();
        // f(i)表示前i个字符的编码次数
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            // 1.一位编码
            if (s.charAt(i - 1) != '0') {
                f[i] = f[i - 1];
            }
            // 2.两位编码
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}
