package offer;

import java.util.Arrays;

/**
 * @author: suruomo
 * @date: 2021/1/26 13:39
 * @description: 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 */
public class MinNumber {
    public String minNumber(int[] nums) {
        String[] strs=new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i]=String.valueOf(nums[i]);
        }
        // 排序
        Arrays.sort(strs,(x,y)->(x+y).compareTo(y+x));
        StringBuilder stringBuilder=new StringBuilder();
        for(String str:strs){
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
