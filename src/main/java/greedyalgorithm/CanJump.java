package greedyalgorithm;

/**
 * 问题55：给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 * @author 苏若墨
 */
public class CanJump {
    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    private static boolean canJump(int[] nums) {
        int n=nums.length;
//        最远可到达下标
        int reachmost=0;
        for(int i=0;i<n;i++){
//            若当前下标小于最远可到达下标，更新
            if(i<=reachmost){
                reachmost=Math.max(reachmost,i+nums[i]);
//                若已经可以到达最后位置，返回true
                if(reachmost>=n-1){
                    return true;
                }
            }
        }
        return false;
    }
}
