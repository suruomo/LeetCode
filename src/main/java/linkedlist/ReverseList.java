package linkedlist;

/**
 * @author suruomo
 * @date 2020/7/27 16:45
 * @description: 206 反转一个单链表。
 */
public class ReverseList {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
        }
    }

    /**
     * 将当前节点的 next 指针改为指向前一个元素。
     * 由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。
     * 在更改引用之前，还需要另一个指针来存储下一个节点。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
