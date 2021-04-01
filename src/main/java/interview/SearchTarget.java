package interview;

/**
 * @author: suruomo
 * @date: 2021/3/31 10:49
 * @description:
 * 在一个转动过的数组中寻找目标值找到返回下标，否则返回-1
 */
public class SearchTarget {
    /**
     *
     * @param A int整型一维数组
     * @param target int整型
     * @return int整型
     */
    public int search (int[] A, int target) {
        int left=0;
        int right=A.length-1;
        while (left<=right){
            int mid=(left+right)/2;
            if (A[mid]==target){
                return mid;
            }
            // 1.如果左边有序,包括mid
            if (A[0]<=A[mid]){
                // 在左边
                if (A[0]<=target&&target<A[mid]){
                    right=mid-1;
                    // 在右边
                }else {
                    left=mid+1;
                }
            }else {
                // 2.右边有序
                // 在右边
                if (A[mid]<=target&&target<A[A.length-1]){
                    left=mid+1;
                }else {
                    right=mid-1;
                }

            }
        }
        return -1;
    }
}
