package interview;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author: suruomo
 * @date: 2021/3/26 10:41
 * @description: 最小的K个数
 * 给定一个数组，找出其中最小的K个数。
 * 例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 */
public class GetLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list=new ArrayList<>();
        if (k> input.length){
            return new ArrayList<>();
        }
        PriorityQueue<Integer> queue=new PriorityQueue<>();
        for (int item:input){
            queue.offer(item);
        }
        while (k>0){
            list.add(queue.poll());
            k--;
        }
        return list;
    }
}
