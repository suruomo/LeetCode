package interview;

/**
 * @author: suruomo
 * @date: 2021/6/1 11:48
 * @description: 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1 {
    public int NumberOf1(int n) {
        int count=0;
        int mask=1;
        while (n!=0){
            if ((n&mask)==1){
                count++;
                mask<<=1;
            }
        }
        return count;
    }
    public int N1umberOf1(int n) {
        int count=0;
        int mask=1;
        while (n!=0){
           n&=n-1;
           count++;
        }
        return count;
    }
}
