package array;

/**
 * @author: suruomo
 * @date: 2020/11/18 10:05
 * @description: 134. 加油站
 * 在一条环路上有N个加油站，其中第i个加油站有汽油gas[i]升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1个加油站需要消耗汽油cost[i]升。
 * 你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 */
public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        // 遍历每一个加油点
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            // 记录从当前加油点出发经过的加油点数
            int cnt = 0;
            while (cnt < n) {
                // 计算环形当前点下标
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                // 消耗大于已有汽油，不满足，退出当前遍历
                if (sumOfCost > sumOfGas) {
                    break;
                }
                // 计数加一
                cnt++;
            }
            // 如果遍历完全部结点，则返回起始编号，结束
            if (cnt == n) {
                return i;
            } else {
                // 不行的话 从下一个站点开始 检查
                i = i + cnt + 1;
            }
        }
        // 未找到返回-1
        return -1;
    }
}
