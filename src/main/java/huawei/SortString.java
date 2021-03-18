package huawei;

import java.util.*;

/**
 * @author: suruomo
 * @date: 2021/3/18 13:58
 * @description:
 * 编写一个程序，将输入字符串中的字符按如下规则排序。
 *
 * 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 *
 * 如，输入： Type 输出： epTy
 *
 * 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 *
 * 如，输入： BabA 输出： aABb
 *
 * 规则 3 ：非英文字母的其它字符保持原来的位置。
 *
 * 如，输入： By?e 输出： Be?y
 */
public class SortString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String input=sc.nextLine();
            System.out.println(sort(input));
        }
    }

    private static String sort(String input) {
        List<Character> letterList=new ArrayList<>();
        // 添加字母列表
        for (Character c:input.toCharArray()) {
            if (Character.isLetter(c)){
                letterList.add(c);
            }
        }
        // 按照字母顺序排序
        Collections.sort(letterList, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return Character.toLowerCase(o1)-Character.toLowerCase(o2);
            }
        });
        StringBuilder stringBuilder=new StringBuilder();
        // 遍历添加字符
        for(int i=0,j=0;i<input.length();i++){
            if (Character.isLetter(input.charAt(i))){
                stringBuilder.append(letterList.get(j++));
            }else {
                stringBuilder.append(input.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
