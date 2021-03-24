package huawei;

import java.util.Scanner;

/**
 * @author: suruomo
 * @date: 2021/3/24 14:28
 * @description:
 * 问题描述：给出4个1-10的数字，通过加减乘除，得到数字为24就算胜利
 * 输入：
 * 4个1-10的数字。数字允许重复，但每个数字仅允许使用一次，测试用例保证无异常数字。
 * 输出：
 * true or false
 */
public class Point24 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int[] nums=new int[4];
            int[] visited=new int[4];
            for (int i = 0; i < 4; i++) {
                nums[i]=sc.nextInt();
            }
            System.out.println(check(nums,visited,0.0));
        }
        sc.close();;
    }

    /**
     * dfs
     * @param nums 四个数字
     * @param visited 是否使用标记
     * @param res 当前值
     * @return
     */
    private static boolean check(int[] nums, int[] visited, double res) {
        for (int i = 0; i < 4; i++) {
            // 如果当前数字未使用
            if (visited[i]==0){
                visited[i]=1;
                if (check(nums, visited, res+nums[i])||
                check(nums, visited, res-nums[i])||
                check(nums, visited, res*nums[i])||
                check(nums, visited, res/nums[i])){
                    return true;
                }
                visited[i]=0;
            }
        }
        if (res==24){
            return true;
        }else {
            return false;
        }
    }
}
