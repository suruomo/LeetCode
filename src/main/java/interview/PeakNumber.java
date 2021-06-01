package interview;

/**
 * @author: suruomo
 * @date: 2021/6/1 10:41
 * @description: 山峰元素是指其值大于或等于左右相邻值的元素。
 * 给定一个输入数组nums，任意两个相邻元素值不相等，
 * 数组可能包含多个山峰。找到索引最大的那个山峰元素并返回其索引。
 * 假设 nums[-1] = nums[n] = -∞。
 */
public class PeakNumber {
    public static int solve (int[] a) {
        int length=a.length;
        if (length==1){
            return 0;
        }
        int left=a[a.length-2];
        int right=Integer.MIN_VALUE;
        for (int i = a.length-1; i >1 ; i--) {
            if (a[i]>left&&a[i]>right){
                return i;
            }else {
                left=a[i-2];
                right=a[i];
            }
        }
        if (a[0]>a[1]){
            return 0;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a={2};
        System.out.println(solve(a));
    }
}
