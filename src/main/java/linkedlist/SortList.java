package linkedlist;

/**
 * @author: suruomo
 * @date: 2020/10/26 10:17
 * @description: 148 排序链表
 */
public class SortList {
    /**
     * 链表定义
     */
    public class ListNode{
        int val;
        ListNode next;
        ListNode(){};
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }

    /**
     * 递归：归并排序
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head){
        // 结束条件
        if (head == null || head.next == null) {
            return head;
        }
        // 使用快慢指针，当fast指向终点时，slow指向中点
        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        //将链表断开
        slow.next = null;
        //左右链表分别递归分割
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode h = new ListNode(0);
        ListNode res = h;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
    }
}
