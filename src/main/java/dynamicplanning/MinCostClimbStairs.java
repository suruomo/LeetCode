package dynamicplanning;

/**
 * 问题：最小花费爬楼梯
 * @author 苏若墨
 */
public class MinCostClimbStairs {
    public static void main(String[] args) {
        int[] cost={5,2,56,3,45,21,4};
        System.out.println("最小花费是："+minCostClimbingStairs(cost));
    }

    private static int  minCostClimbingStairs(int[] cost) {
        int a=0;
        int b=0;
        for(int i=0;i<cost.length;i++){
            int cur=cost[i]+Math.min(a,b);
            a=b;
            b=cur;
        }
        return Math.min(a,b);
    }
}
