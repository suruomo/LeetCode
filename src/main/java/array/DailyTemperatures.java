package array;

/**
 * @author: suruomo
 * @date: 2020/9/17 10:20
 * @description: 739 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。
 * 对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
 * 如果气温在这之后都不会升高，请在该位置用0 来代替。
 * 例如，给定一个列表temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，
 * 你的输出应该是[1, 1, 4, 2, 1, 1, 0, 0]。
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        int[] T={73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(dailyTemperatures(T));
    }

    /**
     * 暴力解决
     * @param T
     * @return
     */
    private static int[] dailyTemperatures(int[] T) {
        int n=T.length;
        for (int i = 0; i < n-1; i++) {
            int d=0;
            for (int j = i+1; j < n; j++) {
                if (T[j]<=T[i]&&j<n-1){
                    d++;
                    continue;
                }
                //直到最后一位也没有气温升高，记为0
                if(T[j]<=T[i]&&j==n-1){
                    T[i]=0;
                    break;
                }
                //找到气温升高的位置
                if(T[j]>T[i]) {
                    d++;
                    T[i]=d;
                    break;
                }
            }
        }
        T[n-1]=0;
        return T;
    }
}
