package array;

import java.util.Stack;

/**
 * @author 苏若墨
 * 问题：Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 思路：使用栈,遍历输入字符串
 *
 * 如果当前字符为左半边括号时，则将其压入栈中
 *
 * 如果遇到右半边括号时，分类讨论：
 *
 * 1）如栈不为空且为对应的左半边括号，则取出栈顶元素，继续循环
 *
 * 2）若此时栈为空，则直接返回false
 *
 * 3）若不为对应的左半边括号，反之返回false
 */
public class MatchCharacter {
    public static void main(String[] args) {
        String s="[()]";
        match(s);
    }
    private static void match(String s) {
        boolean flag=true;
        Stack<Character> stack=new Stack<>();
        char[]c=s.toCharArray();
        for(char r:c){
           if(r=='['||r=='('||r=='{'){
               stack.push(r);
           }
           else if(r==']'||r==')'||r=='}'){
               if(stack!=null&&r==stack.peek()){
                   stack.pop();
               }
               else if(stack==null){
                   flag=false;
                   break;
               }
               else {
                  if(r==']'&&stack.peek()!='['){
                      flag=false;
                      break;
                  }
                  else if(r==')'&&stack.peek()!='('){
                      flag=false;
                      break;
                  }
                  else if(r=='}'&&stack.peek()!='{'){
                      flag=false;
                      break;
                  }
                  stack.pop();
               }
           }
        }
        //循环结束判断
        if(flag==true){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}
