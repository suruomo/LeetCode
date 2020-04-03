package dynamicplanning;

/**
 * @author 苏若墨
 */
public class WaysToStep {
    public static void main(String[] args) {
        int n=76;
        System.out.println(ways(n));
    }

    private static int ways(int n) {
        int[] dp=new int[n];
        if(n==1){
            return 1;
        }
        else if(n==2){
            return 2;
        }
        else if(n==3){
            return 4;
        }
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for(int i=3;i<n;i++){
            dp[i] = ((dp[i - 1]%(1000000007) + dp[i - 2]%(1000000007))%(1000000007) + dp[i - 3]%(1000000007))%(1000000007);
        }
        return dp[n-1];
    }
}
