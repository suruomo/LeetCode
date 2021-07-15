package interview;

import java.util.Stack;

/**
 * @Author: suruomo
 * @Date: 2021/7/15 14:09
 * @Description: 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数，
 * 并且调用 min函数、push函数 及 pop函数 的时间复杂度都是 O(1)
 */
public class MinStack {
    private Stack<Integer> stack1=new Stack<>();
    private Stack<Integer> stack2=new Stack<>();

    public void push(int node) {
        stack1.push(node);
       if (stack2.isEmpty()||stack2.peek()>=node){
           stack2.push(node);
       }
    }

    public void pop() {
        if (stack1.isEmpty()){
            return;
        }
        if (stack1.pop().equals(stack2.peek())){
            stack2.pop();
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
