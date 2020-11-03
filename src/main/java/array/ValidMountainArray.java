package array;

/**
 * @author: suruomo
 * @date: 2020/11/3 10:33
 * @description: 941. 有效的山脉数组
 */
public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        int N=A.length;
        int i=0;
        while (i+1<N&&A[i]<A[i+1]){
            i++;
        }
        if (i==0||i==N-1){
            return false;
        }
        while (i+1<N&&A[i]>A[i+1]){
            i++;
        }
        return i==N-1;
    }
}
