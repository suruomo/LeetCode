package stack;


import java.util.Stack;

/**
 * @author: suruomo
 * @date: 2021/3/3 9:55
 * @description: 150. 逆波兰表达式求值
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 */
public class EvalRPN {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int num1, num2;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    num2 = Integer.parseInt(stack.pop());
                    num1 = Integer.parseInt(stack.pop());
                    num1 = num1 + num2;
                    stack.push(String.valueOf(num1));
                    break;
                case "-":
                    num2 = Integer.parseInt(stack.pop());
                    num1 = Integer.parseInt(stack.pop());
                    num1 = num1 - num2;
                    stack.push(String.valueOf(num1));
                    break;
                case "*":
                    num2 = Integer.parseInt(stack.pop());
                    num1 = Integer.parseInt(stack.pop());
                    num1 = num1 * num2;
                    stack.push(String.valueOf(num1));
                    break;
                case "/":
                    num2 = Integer.parseInt(stack.pop());
                    num1 = Integer.parseInt(stack.pop());
                    num1 = num1 / num2;
                    stack.push(String.valueOf(num1));
                    break;
                default:
                    stack.push(token);
            }
        }
        return Integer.parseInt(stack.peek());
    }
}
