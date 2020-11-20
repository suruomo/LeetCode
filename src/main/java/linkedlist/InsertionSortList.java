package linkedlist;

/**
 * @author: suruomo
 * @date: 2020/11/20 9:56
 * @description: 147. 对链表进行插入排序
 */
public class InsertionSortList {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
        }
    }
    public ListNode insertionSortList(ListNode head) {
        if(head==null){
            return head;
        }
        // 创建哑元结点dummyHead，便于在head之前插入结点
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        // lastSorted 为链表的已排序部分的最后一个节点
        // cur为待插入的元素
        ListNode lastSorted= head,curr=head.next;
        while (curr!=null){
            // 1.如果当前位置满足排序，直接后移指针
            if (lastSorted.val<=curr.val){
                lastSorted=lastSorted.next;
            }else {
                // 2.否则从头开始遍历
                // prev 为插入 curr 的位置的前一个节点m,从头开始遍历
                ListNode prev=dummyHead;
                while (prev.next.val<=curr.val){
                    prev=prev.next;
                }
                // 找到插入位置，变换指针
                lastSorted.next=curr.next;
                curr.next=prev.next;
                prev.next=curr;
            }
            curr=lastSorted.next;
        }
        return dummyHead.next;
    }
}
