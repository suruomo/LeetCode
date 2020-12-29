package offer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2020/12/29 11:13
 * @description: 剑指offer 38 字符串的排列
 */
public class Permutation {
    /**
     * 结果集
     */
    private static List<String> ans=new LinkedList<>();

    public static String[] permutation(String s){
        StringBuffer stringBuffer=new StringBuffer();
        char[] c=s.toCharArray();
        // 排序，便于去重
        Arrays.sort(c);
        boolean[] used = new boolean[s.length()];
        permute(s,stringBuffer,used,c);
        return ans.toArray(new String[ans.size()]);
    }

    /**
     *
     * @param s 原始字符串
     * @param stringBuffer 拼接字符串
     * @param used 判断该字符是否用过，去重
     * @param c 升序数组
     */
    private static void permute(String s,StringBuffer stringBuffer,boolean[] used,char[] c) {
        // 终止条件
        if (stringBuffer.length()==s.length()){
            ans.add(stringBuffer.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!used[i]) {
                // 去重
                if (i > 0 && c[i] == c[i - 1] && used[i - 1]) {
                    continue;
                }
                // 选择
                used[i]=true;
                stringBuffer.append(c[i]);
                // 递推下一位
                permute(s, stringBuffer, used, c);
                // 撤销
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                used[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        String s="aab";
        String[] strings=permutation(s);
        for (String ss:strings){
            System.out.println(ss);
        }
    }
}
