package interview;

/**
 * @author: suruomo
 * @date: 2021/6/7 9:42
 * @description: 旋转数组，右移位置
 */
public class RotateArray {
    /**
     * 数组a一共n个数字，右移m位
     * @param n
     * @param m
     * @param a
     * @return
     */
    public int[] solve (int n, int m, int[] a) {
        int k=m%n;
        swap(a,0,n-1);
        swap(a,0,k-1);
        swap(a,k,n-1);
        return a;
    }

    private void swap(int[] a, int i, int j) {
        while (i<j){
            int t=a[i];
            a[i++]=a[j];
            a[j--]=t;
        }
    }
}
