package interview;

/**
 * @author: suruomo
 * @date: 2021/3/30 11:41
 * @description: 假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
 * 给定两个这种链表，请生成代表两个整数相加值的结果链表。
 */
public class AddList {
    public class ListNode{
        int val;
        ListNode next=null;

        public ListNode(int val) {
            this.val=val;
        }
    }

    /**
     * 两个链表反转后相加然后再反转返回
     * @param head1
     * @param head2
     * @return
     */
    public ListNode addInList (ListNode head1, ListNode head2) {
        head1=reverse(head1);
        head2=reverse(head2);
        ListNode head=new ListNode(-1);
        ListNode cur=head;
        // 进位
        int carry=0;
        while (head1!=null||head2!=null){
            int sum=carry;
            if (head1!=null){
                sum+=head1.val;
                head1=head1.next;
            }
            if (head2!=null){
                sum+=head2.val;
                head2=head2.next;
            }
            cur.next=new ListNode(sum%10);
            carry=sum/10;
            cur=cur.next;
        }
        if (carry>0){
            cur.next=new ListNode(carry);
        }
        return reverse(head.next);
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}
