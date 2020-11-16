package array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author: suruomo
 * @date: 2020/11/16 10:08
 * @description: 406. 根据身高重建队列
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，
 * 其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。
 * 编写一个算法来重建这个队列。
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <= 1) {
            return people;
        }

        /*
            按照 如下规则，给数组排序：
                若两人身高相等，将 p[1]小的 排在前面(这样才能保证 后面的p[1]条件满足)
                若两人身高不等，将 身高高的 排在前面
         */
        Arrays.sort(people, (p1, p2) -> {
            return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
        });

        /*
            根据 排在当前人前面的、比当前人高的 人数，将 所有人放入list中
            由于上面的排序，导致 我们放置后的list中：k值大的排在k值小的后面，k值相同的：身高高的排在身高低的后面
            高个子先站好位，矮个子插入到K位置上，前面肯定有K个高个子，矮个子再插到前面也满足K的要求
         */
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(people);
    }
}
