package array;



import java.util.Arrays;
import java.util.HashMap;

/**
 * @author suruomo
 * @date 2020/7/13 19:43
 * @description: 350 给定两个数组，编写一个函数来计算两个数组交集。
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 */
public class InterSect {
    public static void main(String[] args) {
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        System.out.println(intersect(nums1,nums2));
    }
    public static int[] intersect(int[] nums1, int[] nums2){
        int[] result=new int[nums1.length];
        int index=0;
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        //将第一个数组每个元素出现的次数存入map中
        for(int i=0;i<nums1.length;i++){
            if(!hashMap.containsKey(nums1[i])){
                hashMap.put(nums1[i],1);
            }else {
                hashMap.put(nums1[i],hashMap.get(nums1[i])+1);
            }
        }
        //第二个数组比对交集
        for (int j=0;j<nums2.length;j++){
            //若nums1中也有该数字且出现次数大于0，则相交一次，出现次数减一
            if(hashMap.containsKey(nums2[j])&&hashMap.get(nums2[j])>0){
                hashMap.put(nums2[j],hashMap.get(nums2[j])-1);
                result[index++]=nums2[j];
            }
        }
        return Arrays.copyOfRange(result,0,index);
    }
}
