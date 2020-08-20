package dynamicplanning;

/**
 * @author suruomo
 * @date 2020/8/20 16:00
 * @description: 338 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 */
public class CountBits {
    public static void main(String[] args) {
        int num=5;
        System.out.println(countBits(num));
    }

    private static int[] countBits(int num) {
        int[] res=new int[num+1];
        for(int i  = 0 ; i <= num ; i++){
            res[i] = Integer.bitCount(i);
        }
        return res;
    }
}
