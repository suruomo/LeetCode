/**
 * @author 苏若墨
 * 问题：在一个升序数组中查找两数之和,返回下标，下标从一开始；
 * 思路：双指针碰撞法
 */
public class TwoSumSortedArray {
    public static void main(String[] args) {
        int[] numbers={2,3,5,6,7,9};
        int target=9;
        twoSum(numbers,target);
    }

    private static void twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                System.out.println("下标是："+(left+1)+","+(right+1));
                return;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
    }
}
