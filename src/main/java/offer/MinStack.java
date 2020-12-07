package offer;

import java.util.Stack;

/**
 * @author: suruomo
 * @date: 2020/12/7 10:05
 * @description: 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class MinStack {
    /**
     *  栈 A 用于存储所有元素，保证入栈 push() 函数、出栈 pop() 函数、获取栈顶 top() 函数的正常逻辑。
     *
     *  栈 B中存储栈A中所有非严格降序 的元素，则栈A中的最小元素始终对应栈 B 的栈顶元素，
     *  即 min() 函数只需返回栈 B 的栈顶元素即可。
     */
    Stack<Integer> A,B;
    public MinStack() {
        A=new Stack<>();
        B=new Stack<>();
    }

    public void push(int x) {
        A.add(x);
        // B.peek()>=x避免重复的最小值
        if (B.empty()||B.peek()>=x){
            B.add(x);
        }
    }

    public void pop() {
        if (A.pop().equals(B.peek())){
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
