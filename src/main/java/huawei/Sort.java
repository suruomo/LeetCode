package huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/24 12:09
 * @description: 输出数组前k小数字
 */
public class Sort {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int num=Integer.valueOf(sc.next());
            int k=Integer.valueOf(sc.next());
            int[] arr=new int[num];
            for (int i = 0; i < num; i++) {
                arr[i]=Integer.valueOf(sc.next());
            }
            Arrays.sort(arr);
            for (int i = 0; i < k; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println(" ");
        }
    }
}
