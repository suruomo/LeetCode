package recursive;

import java.util.List;

/**
 * @author: suruomo
 * @date: 2021/1/7 11:52
 * @description: 面试题 08.06. 汉诺塔问题
 *
 */
public class Hanota {
    /**
     * 将 A 上的所有盘子，借助 B，移动到C 上
     * @param A 原柱子
     * @param B 辅助柱子
     * @param C 目标柱子
     */
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        movePlate(A.size(), A, B, C);
    }

    /**
     * 嘀咕i移动过程
     * @param num
     * @param original
     * @param auxiliary
     * @param target
     */
    private void movePlate(int num, List<Integer> original, List<Integer> auxiliary, List<Integer> target) {
        // 只剩一个盘子时，直接移动即可
        if (num == 1) {
            target.add(original.remove(original.size() - 1));
            return;
        }
        // 将 size-1 个盘子，从 original 移动到 auxiliary
        movePlate(num - 1, original, target, auxiliary);
        // 将 第size个盘子，从 original 移动到 target
        target.add(original.remove(original.size() - 1));
        // 将 size-1 个盘子，从 auxiliary 移动到 target
        movePlate(num - 1, auxiliary, original, target);
    }
}
