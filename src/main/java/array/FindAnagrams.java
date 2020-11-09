package array;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2020/11/9 10:15
 * @description: 438. 找到字符串中所有字母异位词
 */
public class FindAnagrams {
    public static void main(String[] args) {
        String s="cbaebabacd";
        String p="abc";
        findAnagrams(s,p);
    }

    private static List<Integer> findAnagrams(String s, String p) {
        int slength=s.length();
        int plength=p.length();
        int[] counts=new int[26];
        // 对p中的每个字符计数
        for (int i = 0; i < plength; i++) {
            counts[p.charAt(i)-'a']++;
        }
        ArrayList<Integer> res=new ArrayList<>();
        // 开始遍历
        for (int i = 0; i <=slength-plength; i++) {
            int[] temp= Arrays.copyOf(counts,26);
            int j=i;
            // 每次在s中遍历p长度子字符串
            for (;j<slength&&j<plength+i;j++){
                // 把子串中每个字符的计数器减一，出现负数则进入下个子串的统计
                if ((--temp[s.charAt(i)-'a'])<0){
                    break;
                }
            }
            // 成功遍历完一个子串，则找到一个字母异分词
            if (j>=plength+i){
                res.add(i);
            }
        }
        return res;
    }
}
