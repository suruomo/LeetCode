package sort;

import java.util.Arrays;

/**
 * 堆排序：升序排序
 * 注：
 * 大顶堆：升序排序
 * 小顶堆:降序排序
 * @author 苏若墨
 */
public class HeapSort {
    public static void main(String[] args) {
        int []arr = {1,5,3,7,4,0,6,8,2,9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 堆排序
     * @param arr
     */
    private static void heapSort(int[] arr) {
        //1.构造大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从左至右调整结构
            adjustHeap(arr,i,arr.length);
        }
        //调整堆结构，每次交换堆顶和堆尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);
            adjustHeap(arr,0,j);
        }
    }

    /**
     * 交换堆顶元素和堆尾元素
     * @param arr
     * @param i
     * @param j
     */
    private static void swap(int[] arr, int i, int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    /**
     * 调整大顶堆，从上至下（i--length)调整
     * @param arr
     * @param i
     * @param length
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        int k;
        int temp=arr[i];
        //从i结点的左子结点开始，也就是2i+1处开始
        for(;i*2+1<length;i=k){
            //如果左子结点小于右子结点，k指向右子结点
            k=i*2+1;
            if(k+1<length&&arr[k+1]>arr[k]){
                k++;
            }
            //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
            if(arr[k]>temp){
                arr[i]=arr[k];
            }
            else{
                break;
            }
        }
        arr[i]=temp;
    }
}
