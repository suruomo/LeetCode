package interview;

/**
 * @author: suruomo
 * @date: 2021/4/12 9:41
 * @description: 将一个链表 m 位置到n 位置之间的区间反转，
 * 要求时间复杂度O(n)，空间复杂度 O(1)。
 */
public class ReverseBetween {
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
    /**
     * 翻转
     *
     * @param head ListNode类
     * @param m    int整型
     * @param n    int整型
     * @return ListNode类
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // M结点的前一个结点
        ListNode mPre = dummy;
        for (int i = 0; i <m-1; i++) {
            mPre=mPre.next;
        }
        ListNode M=mPre.next;
        ListNode pre=M;
        ListNode cur=M.next;
        for (int i = m+1; i <=n; i++) {
            ListNode temp=cur.next;
            cur.next=pre;
            if (i==n){
                M.next=temp;
                mPre.next=cur;
            }
            pre=cur;
            cur=temp;
        }
        return dummy.next;
    }
}



