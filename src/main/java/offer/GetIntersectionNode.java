package offer;

/**
 * @author: suruomo
 * @date: 2020/12/16 11:38
 * @description: 剑指 Offer 52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
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
        if (headA==null||headB==null){
            return null;
        }
        ListNode A1=headA;
        ListNode B1=headB;
        while (A1!=B1){
           A1=A1==null?headB:A1.next;
           B1=B1==null?headA:B1.next;
        }
        return A1;
    }
}
