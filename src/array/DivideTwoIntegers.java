import java.util.Scanner;

/**
 * @author 苏若墨
 * 问题：Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 * 思路：减数一次一次减去被减数，不断更新差，直到差小于0，我们减了多少次，结果就是多少。
 *
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        int dividend,divisor;   //除数，被除数
        System.out.println("请输入除数和被除数：");
        Scanner sc=new Scanner(System.in);
        dividend=sc.nextInt();
        divisor=sc.nextInt();
        divide(dividend,divisor);
    }

    private static void divide(int dividend, int divisor) {
        int count=0;
        int acc=divisor;
        if(dividend<divisor){
            count= 0;
        }
        else if(dividend==0){
            count= 0;
        }
        else if(divisor==1){
            count= dividend;
        }
        else{
            while(dividend-acc>=0){
                acc+=divisor;
                count++;
            }
        }
        System.out.println("商是"+count);
    }
}
