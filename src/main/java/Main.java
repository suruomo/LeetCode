import java.util.Arrays;

/**
 * @author: suruomo
 * @date: 2021/3/24 10:29
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        int []arr = {1,5,3,7,4,0,6,8,2,9};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        int k=0;
        for (int gap = arr.length/2; gap >0; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                int num=arr[i];
                for (k =i; k>=gap&&arr[k-gap]>num ; k-=gap) {
                    arr[k]=arr[k-gap];
                }
                arr[k]=num;
            }
        }
    }

}
