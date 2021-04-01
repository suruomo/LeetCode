package interview;


import java.util.ArrayList;
import java.util.Stack;

/**
 * @author: suruomo
 * @date: 2021/3/31 12:06
 * @description: 实现一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 */
public class GetMInStack {
    // 实现正常栈操作
    Stack<Integer> stack1=new Stack<>();
    // 存放非严格最小元素
    Stack<Integer> stack2=new Stack<>();
    ArrayList<Integer> list=new ArrayList<>();
    /**
     * return a array which include all ans for op3
     * @param op int整型二维数组 operator
     * @return int整型一维数组
     */
    public int[] getMinStack (int[][] op) {
        // write code here
        int len=op.length;
           for(int[] o:op) {
               // 入栈
               if (o[0] == 1) {
                   push(o[1]);
                   // 出栈
               } else if (o[0] == 2) {
                   pop();
               } else {
                   list.add(getMin());
               }
           }
        int[] res=new int[list.size()];
        int i=0;
        for (int num:list){
            res[i++]=num;
        }
        return res;
    }
    public void push(int num){
        stack1.push(num);
        if (stack2.isEmpty()||stack2.peek()>=num){
            stack2.push(num);
        }
    }
    public void pop(){
        int num=stack1.pop();
        if (stack2.peek().equals(num)){
            stack2.pop();
        }
    }
    public int getMin(){
        return stack2.peek();
    }
}
