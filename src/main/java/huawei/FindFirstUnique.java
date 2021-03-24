package huawei;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/24 12:58
 * @description:
 *找出字符串中第一个只出现一次的字符
 * 如果不存在输出-1
 */
public class FindFirstUnique {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            System.out.println(getChar(s));
        }
    }

    private static String getChar(String s) {
        LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
        int len=s.length();
        for (int i = 0; i < len; i++) {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (Map.Entry<Character,Integer> entry:map.entrySet()){
            if (entry.getValue()==1){
                return String.valueOf(entry.getKey());
            }
        }
        return "-1";
    }
}
