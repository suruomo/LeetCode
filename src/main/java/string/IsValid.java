package string;

import java.util.Stack;

/**
 * 问题：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串
 *
 * @author 苏若墨
 */
public class IsValid {

    public  boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() % 2 == 1) {
            return false;
        }
        char[] chars=s.toCharArray();
        Stack<Character> stack=new Stack<>();
        int index=0;
        stack.push(chars[index++]);
        while(index<chars.length){
            char c=chars[index++];
            if(c=='['||c=='{'||c=='('){
                stack.push(c);
                continue;
            }
            if(c==')'&&stack.peek()=='('){
                stack.pop();
                continue;
            }
            if(c==']'&&stack.peek()=='['){
                stack.pop();
                continue;
            }
            if(c=='}'&&stack.peek()=='{'){
                stack.pop();
                continue;
            }
            return false;
        }
        if(!stack.isEmpty()) {
            return false;
        }
        else{
            return true;
        }
    }
}
