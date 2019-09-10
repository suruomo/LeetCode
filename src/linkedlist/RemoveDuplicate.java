package linkedlist;

/**
 * @author 苏若墨
 */
public class RemoveDuplicate {
    static class ListNode{        //节点类
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int x){
            val=x;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
