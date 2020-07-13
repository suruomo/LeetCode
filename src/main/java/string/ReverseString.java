package string;

/**
 * @author suruomo
 * @date 2020/7/13 20:06
 * @description: 344反转字符串数组，原地反转，空间复杂度O(1)
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s={'h','e','l','l','o'};
        reverseString(s);
    }

    private static void reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
        while (i<j){
            char temp=s[i];
            s[i++]=s[j];
            s[j--]=temp;
        }
    }
}
