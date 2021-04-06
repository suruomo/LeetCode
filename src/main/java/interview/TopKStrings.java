package interview;

import java.util.*;

/**
 * @author: suruomo
 * @date: 2021/4/2 10:48
 * @description: 给定String类型的数组strArr，再给定整数k，请严格按照排名顺序打印 出次数前k名的字符串。
 * [要求]
 * 如果strArr长度为N，时间复杂度请达到O(NlogK)
 *
 * 输出K行，每行有一个字符串和一个整数（字符串表示）。
 * 你需要按照出现出现次数由大到小输出，若出现次数相同时字符串字典序较小的优先输出
 */
public class TopKStrings {
    /**
     * return topK string
     * @param strings string字符串一维数组 strings
     * @param k int整型 the k
     * @return string字符串二维数组
     */
    public String[][] topKstrings (String[] strings, int k) {
        if (k == 0) {
            return new String[][]{};
        }
        int len=strings.length;
        HashMap<String,Integer> map=new HashMap<>();
        String[][] res=new String[k][2];
        // 1.map存储字符串出现次数
        for (int i = 0; i <len; i++) {
            map.put(strings[i],map.getOrDefault(strings[i],0)+1);
        }
        // 2.排序
        List<Map.Entry<String,Integer>> list=new ArrayList<>(map.entrySet());
        Collections.sort(list,(o1,o2)->(o1.getValue().compareTo(o2.getValue())==0?o1.getKey().compareTo(o2.getKey()):o2.getValue().compareTo(o1.getValue())));
        // 3.填充结果数组
        for (int i = 0; i < k; i++) {
            res[i][0]=list.get(i).getKey();
            res[i][1]=String.valueOf(list.get(i).getValue());
        }
        return res;
    }
}
