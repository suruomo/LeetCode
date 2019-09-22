package sort;

import java.util.Scanner;

/**
 * 从控制台输入十个数字，冒泡排序（从小到大）实现
 * @author 苏若墨
 *
 */
public class BubbleSort {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums=new int[10];
        System.out.println("请输入待排序整数：");
        int i=0;
        while (i<nums.length) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.printf("请输入第%d个整数：",i+1);
                nums[i]= sc.nextInt();
                i++;
                continue;
            } catch (Exception e) {
                System.out.println("输入不是整数，请重新输入！");
            }
        }
        nums=bubbleSort(nums);
        System.out.println("排序后数组是：：");
        for(int num:nums) {
            System.out.print(num+",");
        }
    }

    /**
     * 冒泡排序
     * @param nums
     * @return nums
     */
    public static int[] bubbleSort(int[] nums) {
        for(int i=0;i<nums.length-1;i++) {
            //一趟排序前flag为true
            boolean flag=true;
            for(int j=nums.length-1;j>i;j--) {
                //交换，置flag为false
                if(nums[j-1]>nums[j]) {
                    int temp=nums[j];
                    nums[j]=nums[j-1];
                    nums[j-1]=temp;
                    flag=false;
                }
            }
            //若一趟排序中没有发生交换，则说明有序跳出循环
            if(flag) {
                break;
            }
        }
        return nums;
    }

}
