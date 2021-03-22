package huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/22 10:04
 * @description: 兄弟单词
 * 定义一个单词的“兄弟单词”为：交换该单词字母顺序，而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如：ab和ba是兄弟单词。ab和ab则不是兄弟单词。
 * 现在给定你n个单词，另外再给你一个单词str，让你寻找str的兄弟单词里，字典序第k大的那个单词是什么？
 * 注意：字典中可能有重复单词。本题含有多组输入数据。
 */
public class BrotherWord {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int num=Integer.valueOf(sc.next());
            String[] strings=new String[num];
            for (int i = 0; i < num; i++) {
                strings[i]=sc.next();
            }
            // 待查找单词
            String find=sc.next();
            // 查找索引
            int index=Integer.valueOf(sc.next());
            List<String> list=new ArrayList<>();
            for (int i = 0; i < num; i++) {
                if (find.length()==strings[i].length()&&!find.equals(strings[i])){
                    if (check(find,strings[i])){
                        list.add(strings[i]);
                    }
                }
            }
            Collections.sort(list);
            System.out.println(list.size());
            if (list.size()>=index){
                System.out.println(list.get(index-1));
            }
        }
    }

    private static boolean check(String find, String str) {
        int[] arr = new int[26];
        char[] ch1 = find.toCharArray();
        char[] ch2 = str.toCharArray();
        for(int i=0; i<ch1.length; i++){
            arr[ch1[i]-'a']++;
            arr[ch2[i]-'a']--;
        }
        for(int i=0; i<26; i++){
            if(arr[i]!=0) {
                return false;
            }
        }
        return true;
    }
}
