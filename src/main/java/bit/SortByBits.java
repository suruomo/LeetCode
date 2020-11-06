package bit;

import java.util.*;

/**
 * @author: suruomo
 * @date: 2020/11/6 10:04
 * @description: 1356. 根据数字二进制下 1 的数目排序
 */
public class SortByBits {
    public static void main(String[] args) {
        int[] arr={0,1,2,3,4,5,6,7,8};
        System.out.println(sortByBits(arr));
    }

    private static int[] sortByBits(int[] arr) {
        int[] bit = new int[10001];
        List<Integer> list=new ArrayList<>();
        for (int num:arr){
            list.add(num);
            // bit[i]为数字i的二进制1个数
            bit[num]=get(num);
        }
        // 排序规则：若两个数的二进制1个数不同，则比较大小
        // 否则比较原本数大小
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (bit[o1]!=bit[o2]){
                    return bit[o1]-bit[o2];
                }else {
                    return o1-o2;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    /**
     * 获取十进制数字的二进制数字中1的个数
     * @param num
     * @return
     */
    private static int get(int num) {
        int count=0;
        while (num!=0){
            // 比较最后一位若是1，则计数加一
            if ((num&1)==1){
                count++;
            }
            // 右移，比较下一位
            num=num>>1;
        }
        return count;
    }
}
