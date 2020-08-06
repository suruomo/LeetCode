package others;

/**
 * @author suruomo
 * @date 2020/8/6 15:27
 * @description:
 */
public class CountAndSay {
    public static void main(String[] args) {
        int n=3;
        System.out.println(countAndSay(n));
    }

    private static String countAndSay(int n) {
        if(n==1) {
            return "1";
        }
        StringBuilder res = new StringBuilder();
        //递归获取上一层结果
        String str = countAndSay(n - 1);
        int length = str.length();
        //双指针
        int a = 0;
        for (int i = 0; i < length + 1; i++) {
            //到达边界直接返回本层结果
            if (i == length) {
                return res.append(i - a).append(str.charAt(a)).toString();
            } else if (str.charAt(i) != str.charAt(a) ) {
                res.append(i - a).append(str.charAt(a));
                a = i;
            }
        }
        return res.toString();
    }
}

