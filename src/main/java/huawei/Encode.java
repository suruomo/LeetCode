package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/22 11:29
 * @description:
 * 1、对输入的字符串进行加解密，并输出。
 *
 * 2、加密方法为：
 *
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 *
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 *
 * 其他字符不做变化。
 *
 * 3、解密方法为加密的逆过程。
 *
 * 输入描述:
 * 输入一串要加密的密码
 * 输入一串加过密的密码
 *
 * 输出描述:
 * 输出加密后的字符
 * 输出解密后的字符
 */
public class Encode {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String encodeString=sc.nextLine();
            String decodeString=sc.nextLine();
            System.out.println(encode(encodeString));
            System.out.println(decode(decodeString));
        }
    }

    /**
     * 解密
     * @param decodeString
     * @return
     */
    private static String decode(String decodeString) {
        StringBuilder s=new StringBuilder();
        int  n=decodeString.length();
        for (int i = 0; i < n; i++) {
            char c=decodeString.charAt(i);
            // 大写字母
            if (Character.isUpperCase(c)){
                int t=(c-'A'-1)%26;
                char cc=(char)('a'+t);
                if (cc<'a'){
                    cc='z';
                }
                s.append(cc);
                // 小写字母
            }else if (Character.isLowerCase(c)){
                int t=(c-'a'-1)%26;
                char cc=(char)('A'+t);
                if (cc<'A'){
                    cc='Z';
                }
                s.append(cc);
                // 数字
            }else{
                char cc=(char)(c-1);
                if (cc<'0') {
                    cc='9';
                }
                s.append(cc);
            }
        }
        return s.toString();
    }

    /**
     * 加密
     * @param encodeString
     * @return
     */
    private static String encode(String encodeString) {
        StringBuilder s=new StringBuilder();
        int  n=encodeString.length();
        for (int i = 0; i < n; i++) {
            char c=encodeString.charAt(i);
            // 大写字母
            if (Character.isUpperCase(c)){
                int t=(c-'A'+1)%26;
                char cc=(char)('a'+t);
                s.append(cc);
            // 小写字母
            }else if (Character.isLowerCase(c)){
                int t=(c-'a'+1)%26;
                char cc=(char)('A'+t);
                s.append(cc);
            // 数字
            }else{
                char cc=(char)(c+1);
                if (cc > '9') {
                    cc='0';
                }
                s.append(cc);
            }
        }
        return s.toString();
    }
}
