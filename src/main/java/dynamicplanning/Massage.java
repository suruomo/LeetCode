package dynamicplanning;

/**
 * @author suruomo
 * @date 2020/8/1 15:02
 * @description: 面试题 17.16. 按摩师
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。

 */
public class Massage {
    public static void main(String[] args) {
        int[] nums={1,2,3,1};
        System.out.println(massage(nums));
    }

    private static int massage(int[] nums) {
        int n=nums.length;
        if (n==0){
            return 0;
        }
        int[] dp=new int[n+1];
        //dp[i]表示预约第i-1个客人时最优值
        dp[0]=0;
        dp[1]=nums[0];
        for (int i=2;i<=n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[n];
    }
}
