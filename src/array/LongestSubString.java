package array;

import java.util.HashMap;
/**
 * @author 苏若墨
 * 问题：Given a string, find the length of the longest substring without repeating characters.
 * 思路：
 * "滑动窗口"
 *     比方说 abcabccc 当你右边扫描到abca的时候你得把第一个a删掉得到bca，
 *     然后"窗口"继续向右滑动，每当加到一个新char的时候，左边检查有无重复的char，
 *     然后如果没有重复的就正常添加，
 *     有重复的话就左边扔掉一部分（从最左到重复char这段扔掉），在这个过程中记录最大窗口长度
 */
public class LongestSubString {
    public static void main(String[] args) {
        String s="abchahbc";
        HashMap<Character,Integer> hashMap=new HashMap<>(10);
        int leftBound = 0;
        int max = 0;
        String sub="";
        for(int i=0; i<s.length();i++){
            char  c = s.charAt(i);
            //窗口左边可能为下一个char，或者不变
            leftBound = Math.max(leftBound,(hashMap.containsKey(c))? hashMap.get(c)+1:0);
            //当前窗口最大长度，记录当前字串
            if(max<=(i-leftBound+1)){
                sub=hashMap.keySet().toString();
                max = Math.max(max, i-leftBound+1);
            }
            //添加该字符
            hashMap.put(c,i);
        }
        System.out.printf("最大字串是：%d\n",max);
        System.out.printf("最大字串是：%s",sub);
    }
}
