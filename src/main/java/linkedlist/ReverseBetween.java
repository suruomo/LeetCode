package linkedlist;

/**
 * @author: suruomo
 * @date: 2021/3/18 12:09
 * @description: 92. 反转链表 II
 * 给你单链表的头节点head 和两个整数left 和 right ，其中left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 */
public class ReverseBetween {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val=x;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 哑元结点
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;
        // 1.确定先驱结点位置
        ListNode pre=dummyNode;
        for (int i = 0; i < left-1; i++) {
            pre=pre.next;
        }
        // 2.确定右边界位置
        ListNode rightNode=pre;
        for (int i = 0; i < right-left+1; i++) {
            rightNode=rightNode.next;
        }
        // 3.确定左边界位置
        ListNode leftNode=pre.next;
        // 4.确定后继结点位置
        ListNode suc=rightNode.next;
        // 5.切断连接，截取链表
        pre.next=null;
        rightNode.next=null;
        // 6.翻转中间片段
        reverse(leftNode);
        // 7.拼接链表
        pre.next=rightNode;
        leftNode.next=suc;
        return dummyNode.next;
    }

    private void reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
    }

}
