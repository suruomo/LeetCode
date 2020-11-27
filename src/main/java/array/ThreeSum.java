package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 苏若墨
 * 问题15：Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * 思路：我们采用`分治`的思想. 想要找出三个数相加等于0，我们可以数组依次遍历，
 * 每一项a[i]我们都认为它是最终能够用组成0中的一个数字，那么我们的目标就是找到
 * 剩下的元素（除a[i]）`两个`相加等于-a[i].
 * 通过上面的思路，我们的问题转化为了`给定一个数组，找出其中两个相加等于给定值`
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        threeSum1(nums);
        System.out.println(threeSum2(nums));
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        //若数组为空或者数组长度小于3，返回空
        if (nums == null || len < 3) {
            return null;
        }
        // 数组排序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 去重
                continue;
            }
            //设置两个左右指针向中间移动
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++; // 去重
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--; // 去重
                    }
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        return ans;
    }

    private static void threeSum1(int[] nums) {
        //对数组进行排序
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过可能重复的答案nums[i] = nums[i - 1]时重复
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                //固定一个数字后，设置左右指针向中间移动
                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    //如果前后两个数字之和等于固定数字的相反数，即满足三数之和为0的条件，加入list
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        // 跳过重复的答案,左指针向右移动
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        // 跳过重复的答案，右指针向左移动
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        //不满足上面条件时执行
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        //两树之和小于预期值，移动左指针
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        l++;
                    } else {
                        //两树之和大于预期值，移动右指针
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        r--;
                    }
                }
            }
        }
        System.out.println("[");
        for (int i = 0; i < ls.size(); i++) {
            System.out.print("[");
            for (int j = 0; j < 3; j++) {
                System.out.print(ls.get(i).get(j) + ",");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
