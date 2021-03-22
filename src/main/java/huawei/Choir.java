package huawei;

import array.MaxConsecutiveOnes;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/19 15:06
 * @description: 合唱队
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 * 说明：
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，
 * 则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形
 *
 *
 * 思路：最长上升子序列
 * 1.求从左至右的LIS和从右至左的LIS
 * 2.两个LIS相加减一
 * 3.总长减去第二步结果
 */
public class Choir {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int num=Integer.valueOf(sc.next());
            int[] nums=new int[num];
            for (int i = 0; i < num; i++) {
                nums[i]=Integer.valueOf(sc.next());
            }
            int[] dp0=new int[num];
            for (int i = 0; i <num; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i]>nums[j]){
                        dp0[i]= Math.max(dp0[i],dp0[j]);
                    }
                }
                dp0[i]+=1;
            }
            int[] dp1=new int[num];
            for (int i = num-1; i>=0; i--) {
                for (int j = num-1; j > i; j--) {
                    if (nums[i]>nums[j]){
                        dp1[i]= Math.max(dp1[i],dp1[j]);
                    }
                }
               dp1[i]+=1;
            }
            int max=0;
            for(int i=0;i<num;i++)
            {
                if(max<dp0[i]+dp1[i]-1) {
                    max=dp0[i]+dp1[i]-1;
                }
            }
            System.out.println(num-max);
        }
    }
}
