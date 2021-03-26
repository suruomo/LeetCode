package interview;

/**
 * @author: suruomo
 * @date: 2021/3/26 11:44
 * @description: 合并链表
 * 将两个有序的链表合并为一个新链表，
 * 要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。
 */
public class MergeLists {
    public class ListNode{
        int val;
        ListNode next=null;
    }
    /**
     * 合并
     * @param l1 ListNode类
     * @param l2 ListNode类
     * @return ListNode类
     */
    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode head=(l1.val <= l2.val)? l1:l2;
        ListNode cur=head;
        l1 = (head == l1)? l1.next:l1;
        l2 = (head == l2)? l2.next:l2;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        cur.next=(l1==null)?l2:l1;
        return head;
    }
}
