package greedyalgorithm;

import java.util.Arrays;

/**
 * 问题1046：有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；
 * 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 * @author 苏若墨
 */
public class LastStoneWeight {
    public static void main(String[] args) {
        int[] stones={2,7,4,1,8,1};
        System.out.println("剩余石头重量为："+lastStoneWeight(stones));
    }

    private static int lastStoneWeight(int[] stones) {
        if(stones.length == 1) {
            return stones[0];
        }
        int index=stones.length-1;
        for(int i=0;i<stones.length;i++) {
            Arrays.sort(stones);
            int x = stones[index];
            int y = stones[index - 1];
            if(x==y){
                stones[index-1]=0;
                stones[index]=0;
            }
            else {
                stones[index-1]=0;
                stones[index]=x-y;
            }
        }
        return stones[stones.length-1];
    }
}
