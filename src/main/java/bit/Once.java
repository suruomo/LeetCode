package bit;

/**
 * @Author: suruomo
 * @Date: 2021/7/20 15:11
 * @Description: 找出一个数组中只出现一次的数字
 */
public class Once {
    public static void main(String[] args) {
        int[] arr={2,2,1,1,3,4,5,4,5};
        System.out.println(slove(arr));
    }

    private static int slove(int[] arr) {
        int ans=0;
        for (int i = 0; i < arr.length; i++) {
            ans^=arr[i];
        }
        return ans;
    }

}
