package interview;

/**
 * @author: suruomo
 * @date: 2021/4/1 10:43
 * @description: 给定一个字符串，请编写一个函数判断该字符串是否回文。如果回文请返回true，否则返回false。
 */
public class JudgePalindrome {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param str string字符串 待判断的字符串
     * @return bool布尔型
     */
    public boolean judge (String str) {
        int i=0;
        int j=str.length()-1;
        while (i<j){
            if (str.charAt(i)!=str.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

