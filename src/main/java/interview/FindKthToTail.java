package interview;

/**
 * @Author: suruomo
 * @Date: 2021/5/18 10:31
 * @Description: 输入一个链表，输出该链表中倒数第k个结点。
 * 如果该链表长度小于k，请返回空。
 */
public class FindKthToTail {
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail (ListNode pHead, int k) {
        if (pHead==null||k<0){
            return null;
        }
        ListNode pre=pHead,cur=pHead;
        while (k>0){
            if (cur==null){
                return cur;
            }
            cur=cur.next;
            k--;
        }
        while (cur!=null){
            cur=cur.next;
            pre=pre.next;
        }
        return pre;
    }
}
