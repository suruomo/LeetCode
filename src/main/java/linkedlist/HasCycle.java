package linkedlist;

import java.util.HashSet;

/**
 * @Author: suruomo
 * @Date: 2020/8/26 10:23
 * @Description: 141 判断链表是否有环
 */
public class HasCycle {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            next = null;
        }
    }

    /**
     * 哈希表判断该节点是否已经遍历
     * 效率不高
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        HashSet<ListNode> set=new HashSet<>();
        while (head!=null){
            if (set.contains(head)){
                return true;
            }
            else {
                set.add(head);
            }
            head=head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * 效率高
     * @param head
     * @return
     */
    public boolean hasCycle2(ListNode head) {
        if (head==null||head.next==null){
            return false;
        }
        ListNode slow=head;
        ListNode fast=head.next;
        while (slow!=fast){
            if(fast==null||fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        //当快指针终将追上慢指针时，一定有环
        return true;
    }
}
