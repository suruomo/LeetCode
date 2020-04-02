package array;


import java.util.Arrays;
import java.util.HashSet;

public class ThirdMaxNumber {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 2};
        System.out.println(thirdMaxNumber(nums));
    }

    private static int thirdMaxNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int[] index = new int[hashSet.size()];
        int i = 0;

        for (int num : hashSet) {
            index[i++] = num;
        }
        Arrays.sort(index);
        if (index.length < 3) {
            return index[index.length - 1];
        } else {
            return index[2];
        }
    }
}
