package interview;

/**
 * @author: suruomo
 * @date: 2021/4/1 10:58
 * @description: 给定一个无序单链表，实现单链表的排序(按升序排序)。
 */
public class SortList {
    public class ListNode{
        int val=0;
        ListNode next=null;
    }
    /**
     *
     * @param head ListNode类 the head node
     * @return ListNode类
     */
    public ListNode sortInList (ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode temp=slow.next;
        slow.next=null;
        ListNode head1=new ListNode();
        ListNode cur=head1;
        // 左右两个链表归并
        ListNode left=sortInList(head);
        ListNode right=sortInList(temp);
        while (left!=null&&right!=null){
            if (left.val<=right.val){
                cur.next=left;
                left=left.next;
            }else {
                cur.next=right;
                right=right.next;
            }
            cur=cur.next;
        }
        cur.next=(left==null)?right:left;
        return head1.next;
    }
}
