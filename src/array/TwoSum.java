package array;

/**
 * 问题：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * @author 苏若墨
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] num={2,7,9,33};
        int target=42;
        System.out.println(twoSum(num,target)[0]+"--"+twoSum(num,target)[1]);
    }

    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("no");
    }
}
