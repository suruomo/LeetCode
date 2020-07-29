package linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suruomo
 * @date 2020/7/29 15:39
 * @description: 234 请判断一个链表是否为回文链表。
 */
public class IsPalindrome {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
        }
    }
    public boolean isPalindrome(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // 1.复制链表值到数组
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // 2.使用双指针
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            // Note that we must use ! .equals instead of !=
            // because we are comparing Integer, not int.
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
