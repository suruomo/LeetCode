package interview;


/**
 * @author: suruomo
 * @date: 2021/3/26 11:09
 * @description: 寻找第K大
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 *
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 */
public class FindKth {
    /**
     * 1.快排思想
     * @param a
     * @param n
     * @param K
     * @return
     */
    public int findKth1(int[] a, int n, int K) {
        // write code here
        return quickSort(a,0,n-1,K);
    }

    private int quickSort(int[] a, int start, int end, int k) {
        if (start<end){
            int partition=sort(a,start,end);
            if(partition>k-1){
                return quickSort(a, start, partition-1, k);
            }else if (partition<k-1){
                return quickSort(a, partition+1, end, k);
            }else{
                return a[partition];
            }
        }
        return -1;
    }

    /**
     * 快速排序:降序排列
     * @param a
     * @param start
     * @param end
     * @return
     */
    private int sort(int[] a, int start, int end) {
        int temp=a[start];
        while (start<end){
            while (start<end&&a[end]<=temp){
                end--;
            }
            a[start]=a[end];
            while (start<end&&a[start]>=temp){
                start++;
            }
            a[end]=a[start];
        }
        a[start]=temp;
        return start;
    }

    private void swap(int[] a, int start, int end) {
        int temp=a[start];
        a[start]=a[end];
        a[end]=temp;
    }

    /**
     * 2.堆排序
     * @param a
     * @param n
     * @param K
     * @return
     */
    public int findKth(int[] a, int n, int K) {
        // 创建堆
        for (int i = n/2-1; i >=0; i--) {
            heapify(a,n,i);
        }
        // 堆排序
        for (int i = n-1; i <n-K+1; i--) {
            swap(a,i,0);
            heapify(a,i,0);
        }
        //
        return a[n-K];
    }

    /**
     * 调整堆
     * @param a
     * @param n 堆大小
     * @param i 当前下标
     */
    private void heapify(int[] a, int n, int i) {
        int hole=a[i];
        // 从结点左子树下标开始
        int k=0;
        for (k=2*i+1; i<n; i=2*k+1) {
            // 右子树比左子树大
            if (k+1<n&&a[k+1]>a[k]){
                k++;
            }
            if (a[k]>hole){
                a[i]=a[k];
            }else {
                break;
            }
        }
        a[k]=hole;
    }
}
