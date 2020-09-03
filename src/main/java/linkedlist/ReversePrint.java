package linkedlist;

import java.util.Stack;

/**
 * @Author: suruomo
 * @Date: 2020/9/3 15:29
 * @Description: 剑指offer 06 从尾到头打印链表
 */
public class ReversePrint {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }
}
