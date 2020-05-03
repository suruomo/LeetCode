package greedyalgorithm;

import java.util.HashMap;


/**
 * 问题860：在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
 * 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
 * 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
 * 注意，一开始你手头没有任何零钱。
 * 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 * @author 苏若墨
 */
public class LemonadeChange {
    public static void main(String[] args) {
        int[] bills={5,5,10,20};
        System.out.println(lemonadeChange(bills));
    }

    private static boolean lemonadeChange(int[] bills) {
        if(bills==null){
            return true;
        }
        if(bills[0]!=5){
            return false;
        }
        int five=0,ten=0;
        for(int i=0;i<bills.length;i++){
            if (bills[i]==5){
               five++;
            }
            if(bills[i]==10){
                if(five>0){
                    five--;
                    ten++;
                }
                else{
                    return false;
                }
            }
            if(bills[i]==20){
              if(ten>0&&five>0){
                  ten--;
                  five--;
              }
              else if(five>2){
                  five=five-3;
              }
              else{
                  return false;
              }
            }
        }
       return true;
    }
}
