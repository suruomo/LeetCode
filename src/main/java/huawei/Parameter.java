package huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/24 16:40
 * @description: 参数解析
 */
public class Parameter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            String[] strings=s.split(" ");
            ArrayList<String> list=new ArrayList<>();
            StringBuilder stringBuilder=new StringBuilder();
            int index=0;
            for(int i=0;i< strings.length;i++){
                String ss=strings[i];
                if (index!=0){
                    index--;
                    continue;
                }
                // 普通字符串直接添加
                if (ss.charAt(0)!='\"'&&ss.charAt(ss.length()-1)!='\"'){
                    list.add(ss);
                }
                if (ss.charAt(0)=='\"'&&ss.charAt(ss.length()-1)=='\"'){
                    list.add(ss.substring(1,ss.length()-1));
                }
                if (ss.charAt(0)=='\"'&&ss.charAt(ss.length()-1)!='\"'){
                    stringBuilder.append(ss.substring(1,ss.length()));
                    for (int j = i+1; j < strings.length; j++) {
                        index++;
                        String temp=strings[j];
                        if (temp.charAt(temp.length()-1)!='\"'){
                            stringBuilder.append(" "+temp);
                        }else {
                            stringBuilder.append(" "+temp.substring(0,temp.length()-1));
                            break;
                        }
                    }
                    list.add(stringBuilder.toString());
                    stringBuilder.delete(0,stringBuilder.length());
                }
            }
            System.out.println(list.size());
            for (String t:list){
                System.out.println(t);
            }
        }
    }
}
