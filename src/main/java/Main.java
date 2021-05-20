import java.util.Arrays;

/**
 * @author: suruomo
 * @date: 2021/3/24 10:29
 * @description:
 */
public class Main {
    public static void main(String[] args) {
        int []arr = {1,5,3,7,4,0,6,8,2,9};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void shellSort(int[] arr) {
        int j=0;
        for (int gap=arr.length/2;gap>0;gap/=2){
            for (int i=gap;i<arr.length;i++){
                int t=arr[i];
                for (j=i;j>=gap&&arr[j-gap]>t;j=j-gap){
                    arr[j]=arr[j-gap];
                }
                arr[j]=t;
            }
        }
    }


}
