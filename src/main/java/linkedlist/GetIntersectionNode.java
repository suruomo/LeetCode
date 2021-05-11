package linkedlist;

/**
 * @author: suruomo
 * @date: 2020/9/15 10:47
 * @description: 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 */
public class GetIntersectionNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            next = null;
        }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA =pA!=null? pA.next:headB;
            pB =pB!=null? pB.next:headA;
        }
        return pA;
    }
}
