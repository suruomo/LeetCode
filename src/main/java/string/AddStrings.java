package string;

/**
 * @author suruomo
 * @date 2020/8/3 9:14
 * @description:
 */
public class AddStrings {
    public static void main(String[] args) {
        String num1="123";
        String num2="123";
        System.out.println(addStrings(num1,num2));
    }

    private static String addStrings(String num1, String num2) {
        //add是进位
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}
