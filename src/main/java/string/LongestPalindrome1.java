package string;

/**
 * @author: suruomo
 * @date: 2021/1/5 18:53
 * @description: 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 */
public class LongestPalindrome1 {
    public int longestPalindrome(String s) {
        // 每种字符出现次数
        int[] cc=new int[60];
        for (Character c:s.toCharArray()){
            cc[(int)c-'A']++;
        }
        // 单个字符标志
        boolean flag=false;
        int count=0;
        for (int i = 0; i < cc.length; i++) {
            if (cc[i]%2==0&&cc[i]>0){
                count+=cc[i];
            }
            if (cc[i]%2==1){
                count+=cc[i]-1;
                flag=true;
            }
        }
        if (flag){
            return count+1;
        }else {
            return count;
        }
    }
}
