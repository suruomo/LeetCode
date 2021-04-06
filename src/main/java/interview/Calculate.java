package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: suruomo
 * @date: 2021/4/1 14:12
 * @description: 表达式求值
 */
public class Calculate {
    public static void main(String[] args) {
        String s="1+3*2";
        System.out.println(solve(s));
    }
    public static int solve (String s) {
      // 操作符栈
      Stack<Character> optStack=new Stack<>();
      // 后缀表达式存储
      List<String> list=new ArrayList<>();
      // 记录数字
      StringBuilder num=new StringBuilder();
      for (char c:s.toCharArray()){
         if (Character.isDigit(c)){
             num.append(c);
         }else{
             // 添加操作数
             if (num.length()!=0){
                 list.add(num.toString());
                 num.delete(0,num.length());
             }
             // 1.左括号
             if (c=='('){
                 optStack.push(c);
                 // 2.右括号
             }else if(c==')'){
                 while (optStack.peek()!='('){
                     list.add(String.valueOf(optStack.pop()));
                 }
                 optStack.pop();
             }else {
                 // 3.乘除直接入栈
                 if (optStack.isEmpty()||optStack.peek().equals('(')||c=='*'||c=='/'){
                     optStack.push(c);
                     // 4.加减遇到加减先出再入
                 }else if((optStack.peek()=='+'||optStack.peek()=='-')&&(c=='+'||c=='-')){
                     list.add(String.valueOf(optStack.pop()));
                     optStack.push(c);
                     // 5.加减遇到乘除先出再入
                 }else if ((optStack.peek()=='*'||optStack.peek()=='/')&&(c=='+'||c=='-')){
                     while ((optStack.peek()=='*'||optStack.peek()=='/')&&(c=='+'||c=='-')){
                         list.add(String.valueOf(optStack.pop()));
                     }
                     optStack.push(c);
                 }
             }
         }
      }
      // 防止最后还有数字
      if (num.length()!=0){
          list.add(num.toString());
      }
      // 栈内所有操作符添加到后缀表达式
      while (!optStack.isEmpty()){
          list.add(String.valueOf(optStack.pop()));
      }
      Stack<Integer> numStack=new Stack<>();
      for(String str:list){
          if (!str.equals("*")&&!str.equals("/")&&!str.equals("+")&&!str.equals("-")){
              numStack.push(Integer.valueOf(str));
          }else {
              int num2=numStack.pop();
              int num1= numStack.pop();
              switch (str){
                  case "+":
                      numStack.push(num1+num2);
                      break;
                  case "-":
                      numStack.push(num1-num2);
                      break;
                  case "*":
                      numStack.push(num1*num2);
                      break;
                  case "/":
                      numStack.push(num1/num2);
              }
          }
      }
      return numStack.pop();
    }
}
