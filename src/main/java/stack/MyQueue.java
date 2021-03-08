package stack;

import java.util.Stack;

/**
 * @author: suruomo
 * @date: 2021/3/5 9:54
 * @description: 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 */
public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    private int size;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1=new Stack<>();
        stack2=new Stack<>();
        size=0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
       stack1.push(x);
       size++;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!stack2.isEmpty()){
            size--;
            return stack2.pop();
        }else {
            if (!stack1.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                size--;
                return stack2.pop();
            }
        }
        return -1;
    }

    /** Get the front element. */
    public int peek() {
        if (!stack2.isEmpty()){
            return stack2.peek();
        }else {
            if (!stack1.isEmpty()){
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                return stack2.peek();
            }
        }
        return -1;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return size==0;
    }
}
