import java.util.Arrays;

/**
 * @author: suruomo
 * @date: 2021/3/24 10:29
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        String s="11";
        String t="99";
        System.out.println(solve(s,t));
    }
    public static String solve (String s, String t) {
        char[] chars1=s.toCharArray();
        char[] chars2=t.toCharArray();
        int i=s.length()-1;
        int j=t.length()-1;
        // 进位
        int carry=0;
        StringBuilder stringBuilder=new StringBuilder();
        while (i>=0||j>=0||carry!=0){
            int a=0,b=0;
            if (i>=0){
                a=chars1[i]-'0';
                i--;
            }
            if (j>=0){
                b=chars2[j]-'0';
                j--;
            }
            int sum=a+b+carry;
            int rem=sum%10;
            carry=sum/10;
            stringBuilder.append(rem);
        }
        stringBuilder.reverse();
        return new String(stringBuilder);
    }
}
