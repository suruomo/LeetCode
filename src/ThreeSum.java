import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
*@author 苏若墨
 * 问题：Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * 思路：我们采用`分治`的思想. 想要找出三个数相加等于0，我们可以数组依次遍历，
 * 每一项a[i]我们都认为它是最终能够用组成0中的一个数字，那么我们的目标就是找到
 * 剩下的元素（除a[i]）`两个`相加等于-a[i].
 * 通过上面的思路，我们的问题转化为了`给定一个数组，找出其中两个相加等于给定值`
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums={-1, 0, 1, 2, -1, -4};
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // 跳过可能重复的答案
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;   // 跳过重复值
                        }
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }

                        r--;
                    }
                }
            }
        }
        System.out.println("[");
        for(int i=0;i<ls.size();i++){
            System.out.print("[");
            for(int j=0;j<3;j++){
                System.out.print(ls.get(i).get(j)+",");
            }
            System.out.println("]");
        }
        System.out.println("]");
    }
}
