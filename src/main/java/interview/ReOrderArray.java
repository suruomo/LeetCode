package interview;

/**
 * @author: suruomo
 * @date: 2021/6/16 13:22
 * @description: 调整数组顺序使奇数位于偶数前面
 * 奇数偶数保持相对位置不变
 */
public class ReOrderArray {
    public int[] reOrderArray (int[] array) {
        // write code here
        //双指针，头尾指针
        int[] nums = new int[array.length];
        int head = 0;
        int tail = array.length-1;
        int index_head = head;
        int index_tail = tail;
        while(head < array.length && tail >= 0){
            if(array[head] % 2 == 1){
                //奇数，放前面
                nums[index_head] = array[head];
                index_head++;
            }
            head++;
            if(array[tail] % 2 == 0){
                //从后到前，如果为偶数，则从后开始填
                nums[index_tail] = array[tail];
                index_tail--;
            }
            tail--;
        }
        return nums;
    }
}
