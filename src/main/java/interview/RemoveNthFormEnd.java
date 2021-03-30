package interview;

/**
 * @author: suruomo
 * @date: 2021/3/29 16:51
 * @description: 给定一个链表，删除链表的倒数第 n 个节点并返回链表的头指针
 */
public class RemoveNthFormEnd {
    public class ListNode{
        int val;
        ListNode next=null;
    }
    /**
     * 快慢指针
     * @param head ListNode类
     * @param n int整型
     * @return ListNode类
     */
    public ListNode removeNthFromEnd (ListNode head, int n) {
        // write code here
        ListNode form=head;
        ListNode pre=head;
        ListNode cur=head;
        int k=0;
        while (k<n){
            form=form.next;
            k++;
        }
        while (form!=null){
            form=form.next;
            pre=cur;
            cur=cur.next;
        }
        // 如果链表不为空
        if (cur!=head){
            pre.next=cur.next;
        }else {
            head=head.next;
        }
        return head;
    }
}
