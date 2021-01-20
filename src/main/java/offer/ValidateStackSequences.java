package offer;

import java.util.Stack;

/**
 * @author: suruomo
 * @date: 2021/1/20 11:20
 * @description: 剑指 Offer 31. 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 */
public class ValidateStackSequences {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 标记弹出序列当前索引
        int i=0;
        // 模拟栈操作
        Stack<Integer> stack=new Stack<>();
        // 遍历压入序列
        for (int num: pushed ) {
            stack.push(num);
            // 循环判断与出栈
            while (!stack.isEmpty()&&stack.peek()==popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
