package interview;

/**
 * @author: suruomo
 * @date: 2021/3/30 16:54
 * @description:
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 */
public class Fibonacci {
    public int Fibonacci(int n) {
        if (n==0||n==1){
            return n;
        }
        int oldNum=0;
        int newNum=1;
        for (int i = 2; i <=n; i++) {
            int temp=newNum;
            newNum=newNum+oldNum;
            oldNum=temp;
        }
        return newNum;
    }
}
