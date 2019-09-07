package array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MissNumbers {
    public static void main(String[] args) {
        int[]nums={3,1,0};
        miss(nums);
    }

    private static List<Integer> miss(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        List<Integer> list=new ArrayList<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                list.add(number);
            }
        }
        return list;
    }
}
