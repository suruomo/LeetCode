package offer;

import java.util.Arrays;

/**
 * @author: suruomo
 * @date: 2020/12/23 10:47
 * @description: 剑指 Offer 61. 扑克牌中的顺子
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。
 * A 不能视为 14。
 * 输入: [0,0,1,2,5]
 * 输出: True
 */
public class IsStraight {
    public boolean isStraight(int[] nums) {
        int joker=0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (nums[i]==0){
                // 统计大小王数量，大小王可以为任意数字
                joker++;
            }else if (nums[i]==nums[i+1]){
                // 若有重复，提前返回
                return false;
            }
        }
        // 最大牌 - 最小牌 < 5 则可构成顺子
        return nums[4]-nums[joker]<5;
    }
}
