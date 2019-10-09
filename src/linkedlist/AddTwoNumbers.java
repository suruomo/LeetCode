package linkedlist;

/**
 * @author 苏若墨
 * 问题：给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 *  * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  * Output: 7 -> 0 -> 8
 */
class AddTwoNumbers {
    public ListNode add(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        //carry 表示进位数
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            //进位数
            carry = sum / 10;
            //新节点的数值为sum % 10
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }

        }
        //下一位数字为当前运算的进位
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
    class ListNode{
           int val;
           ListNode next;
           ListNode(int x){
              val=x;
         }
     }
}
