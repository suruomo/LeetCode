package offer;

import java.util.Stack;

/**
 * 剑指offer09:用两个栈实现一个队列。请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * @author 苏若墨
 */
public class CQueue {
    /**
     * stack1负责模拟入队列appendTail 操作
     */
    private Stack<Integer> stack1;
    /**
     * stack2负责模拟出队列deleteHead 操作
     */
    private Stack<Integer> stack2;
    /**
     * 队列长度
     */
    private int size;

    public CQueue(){
        stack1=new Stack<>();
        stack2=new Stack<>();
        size=0;
    }

    /**
     * 入队操作
     * @param value 入队元素
     */
    public void appendTail(int value){
        stack1.push(value);
        size++;
    }

    /**
     * 出队操作
     * @return 返回头元素
     */
    public int deleteHead(){
        if(size==0){
            return -1;
        }
        if(stack2.size()==0){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        size--;
        return stack2.pop();
    }
    public static void main(String[] args) {
        CQueue cQueue=new CQueue();
        cQueue.appendTail(1);
        System.out.println(cQueue.deleteHead());
    }
}
