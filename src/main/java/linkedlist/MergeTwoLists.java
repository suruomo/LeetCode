package linkedlist;

/**
 * @author suruomo
 * @date 2020/7/12 19:08
 * @description: 21:将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class MergeTwoLists {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        ListNode head=new ListNode();
        ListNode now=head;
        while (l1!=null&&l2!=null){
            if (l1.val<=l2.val){
                now.next=l1;
                l1=l1.next;
            }
           else {
                  now.next=l2;
                  l2=l2.next;
            }
            now=now.next;
        }
        if(l1==null){
            now.next=l2;
        }
        if(l2==null){
            now.next=l1;
        }
        return head.next;
    }

}

