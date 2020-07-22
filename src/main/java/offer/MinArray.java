package offer;

import java.util.Arrays;

/**
 * @author suruomo
 * @date 2020/7/22 16:09
 * @description:剑指offer 11 旋转数字的最小数字
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 */
public class MinArray {
    public static void main(String[] args) {
        int[] numbers={3,4,5,1,2};
        System.out.println(minArray(numbers));
    }

    /**
     * 胡说八道法
     * @param numbers
     * @return
     */
    private static int minArray(int[] numbers) {
        int n=numbers.length;
        Arrays.sort(numbers);
        return numbers[0];
    }

    /**
     * 二分法
     * @param numbers
     * @return
     */
    private static int minArray1(int[] numbers){
            int low = 0;
            int high = numbers.length - 1;
            while (low < high) {
                int pivot = low + (high - low) / 2;
                if (numbers[pivot] < numbers[high]) {
                    high = pivot;
                } else if (numbers[pivot] > numbers[high]) {
                    low = pivot + 1;
                } else {
                    //由于可能的重复元素存在，只缩小一部分
                    high -= 1;
                }
            }
            return numbers[low];
    }
}
