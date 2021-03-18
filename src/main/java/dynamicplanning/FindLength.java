package dynamicplanning;

/**
 * @author: suruomo
 * @date: 2021/3/16 12:07
 * @description: 718. 最长重复子数组
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 */
public class FindLength {
    public static void main(String[] args) {
        String s1="abchf";
        String s2="bch";
        System.out.println(findCommons(s1,s2));
    }

    /**
     * 返回最长公共子串
     * @param s1
     * @param s2
     * @return
     */
    private static String findCommons(String s1, String s2) {
        if (s1.length()>s2.length()){
            String temp=s1;
            s1=s2;
            s2=temp;
        }
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        // 最大长度
        int maxLength=0;
        // 最大长度最后一个字符下标
        int lastIndex=0;
        dp[0][0]=0;
        for (int i = 1; i <=s1.length(); i++) {
            for (int j = 1; j <=s2.length(); j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if (dp[i][j]>maxLength){
                        maxLength=dp[i][j];
                        lastIndex=i-1;
                    }
                }
            }
        }
        return s1.substring(lastIndex-maxLength+1,maxLength);
    }

    /**
     * 返回两个数组中公共的、长度最长的子数组的长度
     * @param A
     * @param B
     * @return
     */
    public int findLength(int[] A, int[] B) {
        // dp[i][j]表示下标i-1,j-1的最长
        int[][] dp=new int[A.length+1][B.length+1];
        dp[0][0]=0;
        int ans=0;
        for (int i = 1; i <=A.length; i++) {
            for (int j = 1; j <=B.length; j++) {
                if (A[i-1]==B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}
