package interview;

/**
 * @author: suruomo
 * @date: 2021/4/16 10:31
 * @description:
 */
public class OddEvenList {
    public class ListNode{
        int val;
        ListNode next=null;
        public ListNode(int val){
            this.val=val;
        }
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode oddEvenList (ListNode head) {
        if (head==null){
            return head;
        }
       ListNode oddHead=head;
       ListNode odd=oddHead,even=head.next;
       ListNode evenHead=head.next;
       while (even!=null&&even.next!=null){
           odd.next=even.next;
           odd=odd.next;
           even.next=odd.next;
           even=even.next;
       }
       odd.next=evenHead;
       return oddHead;
    }

}
