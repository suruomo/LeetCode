package array;


/**
 * @author: suruomo
 * @date: 2020/10/27 9:51
 * @description: 215  数组中的第K个最大元素
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums={3,2,1,5,6,4};
        int k=2;
        System.out.println(findKthLargest(nums,k));
    }

    /**
     * 1.快速排序
     * @param nums
     * @param k
     * @return
     */
    private static int findKthLargest(int[] nums, int k) {
        if (nums==null||k<1){
            return 0;
        }
        quickSort(nums,0,nums.length-1);
        return nums[nums.length-k];
    }
    /**
     * 快速排序
     * @param arr 待排序数组
     * @param start 起始下标
     * @param end  终止下标
     */
    private static void quickSort(int[] arr, int start, int end) {
        //如果只有一个元素时终止排序
        if(start>=end){
            return;
        }
        int partition = divide(arr, start, end);
        //以基准划分两边分别递归的进行快排
        quickSort(arr,start,partition-1);
        quickSort(arr,partition+1,end);
    }

    /**
     * 划分函数，以基准为界限，基准右边的元素都比基准小，基准左边元素都比基准大
     * @param arr 待划分数组
     * @param start 起始下标
     * @param end  终止下标
     * @return  返回基准所在下标
     */
    private static int divide(int[] arr, int start, int end) {
        //选取划分标准
        int base=arr[end];
        while (start<end){
            // 从左向右移动，若当前元素小于基准，满足划分条件，start++继续向右移动
            while(start<end&&arr[start]<=base){
                start++;
            }
            //当前元素大于基准时，进行交换
            if(start<end){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                end--;
            }
            // 从右向左移动，若当前元素大于基准，满足划分条件，end--继续向左移动
            while (start<end&&arr[end]>=base){
                end--;
            }
            //当前元素小于基准时，进行交换
            if(start<end){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
            }
        }
        //返回基准所在下标，end或者start都可以
        return end;
    }

    /**
     *2.堆排序
     * @param nums
     * @param k
     * @return
     */
    private static int findKthLargest1(int[] nums, int k) {
       int size=nums.length;
       // 创建大顶堆
       buildMaxHeap(nums,size);
       // 排序前k个，此时堆顶即nums[0]为第k大个元素
       for (int i = nums.length-1; i >=nums.length-k+1; i--) {
            swap(nums,0,i);
            size--;
            adjust(nums,0,size);
        }
       return nums[0];
    }

    /**
     * 创建大顶堆
     * @param nums
     * @param length
     */
    private static void buildMaxHeap(int[] nums, int length) {
        for (int i = length/2-1; i >=0; i--) {
            adjust(nums,i,length);
        }
    }

    /**
     * 调整堆
     * @param nums
     * @param i
     * @param length
     */
    private static void adjust(int[] nums, int i, int length) {
        int hole=nums[i];
        for (int j = 2*i+1; j < length; j=2*j+1) {
            if (j+1<length&&nums[j]<nums[j+1]){
                j++;
            }
            if (nums[j]>hole){
                // 交换值
                swap(nums,i,j);
                i=j;
            }else {
                break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }


}
