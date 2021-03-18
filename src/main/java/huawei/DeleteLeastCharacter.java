package huawei;


import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/18 13:40
 * @description:
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。
 * 输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 注意每个输入文件有多组输入，即多个字符串用回车隔开
 */
public class DeleteLeastCharacter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String input=sc.nextLine();
            System.out.println(delete(input));
        }
    }

    private static String delete(String input) {
        HashMap<Character,Integer> map=new HashMap<>();
        int minCount=Integer.MAX_VALUE;
        StringBuilder stringBuilder=new StringBuilder();
        int n=input.length();
        // 记录出现次数
        for (int i = 0; i < n; i++) {
            map.put(input.charAt(i),map.getOrDefault(input.charAt(i),0)+1);
        }
        // 找到最小出现次数
        for (Integer item:map.values()) {
            minCount=Math.min(item,minCount);
        }
        for (int i = 0; i < n; i++) {
            if (map.get(input.charAt(i))!=minCount){
                stringBuilder.append(input.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
