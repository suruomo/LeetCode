package interview;

import java.util.Arrays;

/**
 * @Author: suruomo
 * @Date: 2021/7/13 13:09
 * @Description: 给定一个数组由一些非负整数组成，现需要将他们进行排列并拼接，使得最后的结果最大，返回值需要是string类型 否则可能会溢出
 */
public class BigNumber {

    public String solve (int[] nums) {
        if (nums[0]==0){
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        String[] strings=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(strings,(x, y)->(y+x).compareTo(x+y));
        for (int i = 0; i < nums.length; i++) {
            ans.append(strings[i]);
        }
        return ans.toString();
    }
}
