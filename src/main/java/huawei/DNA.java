package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/24 13:28
 * @description:
 */
public class DNA {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            int num=sc.nextInt();
            System.out.println(find(s,num));
        }
    }

    private static String find(String s,int k) {
        int max=0;
        String res="";
        for (int i = 0; i <s.length()-k+1; i++) {
            int temp=count(s.substring(i,i+k));
            if (temp>max){
                max=temp;
                res=s.substring(i,i+k);
            }
        }
        return res;
    }

    private static int count(String substring) {
        int count=0;
        for (int i = 0; i < substring.length(); i++) {
            char c=substring.charAt(i);
            if (c=='C'||c=='G'){
                count++;
            }
        }
        return count;
    }
}
