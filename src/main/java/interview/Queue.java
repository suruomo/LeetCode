package interview;

import java.util.Stack;

/**
 * @author: suruomo
 * @date: 2021/3/26 12:50
 * @description:
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Queue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    /**
     * 栈容量
     */
    private int size;

    public Queue(int size) {
        this.size = size;
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void push(int node) {
        if (stack1.size()+stack2.size()<=size){
            stack1.push(node);
        }else {
            throw new IndexOutOfBoundsException("栈已满");
        }
    }

    public int pop() {
        if (stack2.isEmpty()){
            if (stack1.isEmpty()){
                return -1;
            }else {
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }
}
