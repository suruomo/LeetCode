package array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author: suruomo
 * @date: 2020/12/30 10:30
 * @description: 1046. 最后一块石头的重量
 * 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出两块最重的石头，然后将它们一起粉碎。
 * 假设石头的重量分别为x 和y，且x <= y。那么粉碎的可能结果如下：
 * 如果x == y，那么两块石头都会被完全粉碎；
 * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        // 构造降序比较器
        Comparator<Integer> comparator=new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        };
        // 优先队列改为最大堆（默认为最小堆）
        PriorityQueue<Integer> pq=new PriorityQueue<>(comparator);
        // 也可以直接写成下面形式
        //  PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for (int stone:stones) {
            pq.offer(stone);
        }
        while (pq.size()>1){
            // a>=b
            int a=pq.poll();
            int b=pq.poll();
            if (a>b){
                pq.offer(a-b);
            }
        }
        return pq.isEmpty()?0:pq.poll();
    }
}
