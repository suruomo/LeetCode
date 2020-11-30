package offer;

/**
 * @author: suruomo
 * @date: 2020/11/27 15:57
 * @description: 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *
 * 返回删除后的链表的头节点。
 */
public class DeleteNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode deleteNode(ListNode head, int val) {
        if (head==null){
            return null;
        }
        if (head.val==val){
            head=head.next;
            return head;
        }
        ListNode cur=head;
        while (cur.next!=null){
            if (cur.next.val==val){
                cur.next=cur.next.next;
                return head;
            }
            cur=cur.next;
        }
        return head;
    }
}
