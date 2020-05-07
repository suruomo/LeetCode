package greedyalgorithm;

/**
 * 问题1221：在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * 返回可以通过分割得到的平衡字符串的最大数量。
 *
 * @author 苏若墨
 */
public class BalanceStringSplit {
    public static void main(String[] args) {
        String s="RLRRLLRLRL";
        System.out.println(balanceStringSplit(s));
    }

    private static int balanceStringSplit(String s) {
        int count=0;
        int balance=0;
        char[] chars=s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if('L'==chars[i]){
                balance--;
            }
             if('R'==chars[i]){
                balance++;
            }
//            达到平衡
            if(balance==0){
                count++;
            }
        }
        return count;
    }
}
