package dynamicplanning;

import java.util.Arrays;

/**
 * 动态规划;0-1背包
 *
 * @author 苏若墨
 */
public class BeiBao {

    public static int knapsack(int[] weight, int[] value, int maxweight) {

        int n = weight.length;
        //最大价值数组为maxvalue[n+1][maxWeight+1]，因为我们要从0开始保存
        int[][] maxvalue = new int[n + 1][maxweight + 1];

        //重量和物品为0时，价值为0
        for (int i = 0; i < maxweight + 1; i++) {
            maxvalue[0][i] = 0;

        }
        for (int i = 0; i < n + 1; i++) {
            maxvalue[i][0] = 0;

        }
        // i：在前i件物品中选取若干物品（这里的i因为取了0，所以对应到weight和value里面都是i-1号位置）
        // j：剩余背包重量为j
        // maxvalue[i][j]表示在前i件物品中选取若干物品，此时剩余容量为j的背包中的最大价值
        // n是物品件数
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxweight; j++) {
                //1.当前件的重量大于总重量，则不放当前，当前最大价值等于放上一件物品的最大价值
                maxvalue[i][j] = maxvalue[i - 1][j];
                //2.当前件的重量小于总重量，可以放进去或者拿出别的东西再放进去（不是最优解）
                if (weight[i - 1] <= j) {
                    //比较（不放这个物品的价值）和
                    //（这个物品的价值 加上 当前能放的总重量减去当前物品重量时取前i-1个物品时的对应重量时候的最高价值）
                    maxvalue[i][j] = Math.max(maxvalue[i - 1][j - weight[i - 1]] + value[i - 1],maxvalue[i - 1][j]);
                }
            }
        }

        //找出价值最大时，包内装入了哪些物品？
        // 下标i对应的物品若被选中，设置值为1
        int[] item = new int[n + 1];
        // 将数组item的所有元素初始化为0
        Arrays.fill(item, 0);

        // 从最优解，倒推回去找
        int j = maxweight;
        for (int i = n; i > 0; i--) {
            // 在最优解中，maxvalue[i][j] > maxvalue[i - 1][j]说明选择了第i个商品
            if (maxvalue[i][j] > maxvalue[i - 1][j]) {
                item[i] = 1;
                j = j - weight[i];
            }
        }

        System.out.print("包内物品的编号为：");
        for (int i = 0; i < n + 1; i++) {
            if (item[i] == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
        return maxvalue[n][maxweight];
    }

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        int[] weight = {2, 3, 4, 5};
        int[] value = {3, 4, 5, 7};
        int maxWeight = 9;
        System.out.println("该背包能装下的最大价值是：" + knapsack(weight, value, maxWeight));
    }

}