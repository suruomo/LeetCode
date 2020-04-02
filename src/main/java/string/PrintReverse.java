package string;

/**
 * 问题：反向打印字符串（递归）
 * @author 苏若墨
 */
public class PrintReverse {
    public static void main(String[] args) {
        String s="123456";
        printReverse(s);
    }

    private static void printReverse(String s) {
        if(s.length()==1){
            System.out.print(s);
        }
        else{
            System.out.print(s.charAt(s.length()-1));
            printReverse(s.substring(0,s.length()-1));
        }
    }
}
