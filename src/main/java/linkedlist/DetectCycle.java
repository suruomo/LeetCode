package linkedlist;

import java.util.HashSet;

/**
 * @author: suruomo
 * @date: 2020/10/9 10:27
 * @description: 142 环形链表2
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class DetectCycle {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            next = null;
        }
    }

    /**
     * 哈希
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set=new HashSet<>();
        while (head!=null){
            if (set.contains(head)){
                return head;
            }
            else {
                set.add(head);
            }
            head=head.next;
        }
        return null;
    }

    /**
     * 快慢指针
     * 数学推导
     * @param head
     * @return
     */
    public ListNode detectCycle1(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
