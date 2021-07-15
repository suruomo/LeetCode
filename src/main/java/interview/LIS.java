package interview;

/**
 * @Author: suruomo
 * @Date: 2021/7/15 13:16
 * @Description: 给定数组arr，设长度为n，输出arr的最长递增子序列。
 * （如果有多个答案，请输出其中 按数值(注：区别于按单个字符的ASCII码值)进行比较的 字典序最小的那个）
 */
public class LIS {

    public int[] LIS (int[] arr) {
        int length=arr.length;
        int[] dp=new int[length];
        int maxLength=1;
        int lastIndex=0;
        dp[0]=1;
        for (int i = 1; i <length+1; i++) {
            dp[i]=1;
            for (int j = 0; j <i ; j++) {
                if (arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
                if (dp[i]>maxLength){
                    maxLength=dp[i];
                    lastIndex=i;
                }
            }
        }
        int[] res=new int[maxLength];
        res[--maxLength]=arr[lastIndex];
        for (int i = lastIndex; i>=0 ; i--) {
            if ((arr[i]<arr[lastIndex])&&(dp[i]==dp[i+1]-1)){
                res[--maxLength]=arr[i];
                lastIndex=i;
            }
        }
        return res;
    }
}
