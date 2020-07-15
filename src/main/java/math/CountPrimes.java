package math;

/**
 * @author suruomo
 * @date 2020/7/15 16:00
 * @description: 204 统计所有小于非负整数 n 的质数的数量。
 */
public class CountPrimes {
    public static void main(String[] args) {
        int n=10;
        System.out.println(countPrimes(n));
    }

    private static int countPrimes(int n) {
        int result = 0;
        // 初始化默认值都为 false，为质数标记
        boolean[] b = new boolean[n];
        if(2 < n) {
            result++; // 如果大于 2 则一定拥有 2 这个质数
        }
       // 从 3 开始遍历，且只遍历奇数
        for(int i = 3; i < n; i += 2){
            // 是质数
            if(!b[i]){
                for(int j = 3; i * j < n; j += 2){
                    // 将当前质数的奇数倍都设置成非质数标记 true
                    b[i * j] = true;
                }
                result++;   // 质数个数 +1
            }
        }
        return result;
    }
}
