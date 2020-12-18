package offer;

/**
 * @author: suruomo
 * @date: 2020/12/18 12:00
 * @description: 剑指 Offer 65. 不用加减乘除做加法
 */
public class Add {
    public int add(int a, int b) {
        while(b != 0){
            int temp = a ^ b;
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}
